package br.com.mioto.cloud.controllers;

import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.kv.model.GetValue;
import com.google.gson.Gson;

import br.com.mioto.cloud.vo.Microservice;

/**
 * Created by mioto on 22/05/17.
 */
@RestController
public class ConsulController {

    private static final Logger log = LoggerFactory.getLogger(ConsulController.class);

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ConsulClient consulClient;



    @Value("${spring.application.name:user-management-rest}")
    private String appName;

    @RequestMapping("/me")
    public ServiceInstance me() {
        return discoveryClient.getLocalServiceInstance();
    }

    @RequestMapping("/")
    public ServiceInstance lb() {
        return loadBalancer.choose(appName);
    }

    @RequestMapping("/rest")
    public String rest() {
        return this.restTemplate.getForObject("http://" + appName + "/me", String.class);
    }

    @RequestMapping("/choose")
    public String choose() {
        return loadBalancer.choose(appName).getUri().toString();
    }

    @RequestMapping("/instances")
    public List<ServiceInstance> instances() {
        return discoveryClient.getInstances(appName);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/kv-put")
    public void kvPut() {
        if(!isKVUpdated()){
            this.kvDelete();
            consulClient.setKVValue(appName, this.getDependencyJson());
            log.info("KV was updated");
        }else{
            log.info("KV is already updated");
        }

    }

    @RequestMapping(value = "/kv-get", method = RequestMethod.GET, produces = "application/json")
    public String kvGet() {
        return getKV();
    }

    private String getKV(){
        final GetValue getValue = consulClient.getKVValue(appName).getValue();
        return getValue == null ? null : new String(Base64.getDecoder().decode(getValue.getValue()));
    }

    private String getDependencyJson(){
        final Microservice dependency = new Microservice();

        final Set<Microservice> dependencyList = new HashSet<Microservice>();
        dependencyList.add(dependency);

        final Microservice kv = new Microservice();
        kv.setVersion("1.0");
        kv.setDependencies(dependencyList);

        final Gson g = new Gson();
        final String kvJson = g.toJson(kv);
        return kvJson;
    }

    public void kvDelete() {
        consulClient.deleteKVValue(appName);
    }

    public boolean isKVUpdated(){
        final String value =  getKV();
        final String updatedDependecyJson = getDependencyJson();
        if((value != null) && value.equals(updatedDependecyJson)){
            return true;
        }
        return false;
    }

}
