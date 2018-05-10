package com.fosun.beauty.security;




import com.fosun.beauty.domain.SysResource;
import com.fosun.beauty.service.SysResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class FosunInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    Logger log = LoggerFactory.getLogger(FosunInvocationSecurityMetadataSource.class);

    @Autowired
    private SysResourceService sysResourceService;

    private HashMap<String, Collection<ConfigAttribute>> map = null;

    /**
     * Load the resource, initialize the resource variable
     */
    public void loadResourceDefine() {
        map = new HashMap<>();
        Collection<ConfigAttribute> array;

        List<SysResource> resources = sysResourceService.findAllChildSysResource();
        for (SysResource resource : resources) {
            if(map.get(resource.getUrl())!=null){
                array = map.get(resource.getUrl());
            }else{
                array = new ArrayList<>();
            }
            ConfigAttribute cfg = new SecurityConfig(resource.getName());
            array.add(cfg);
            map.put(resource.getUrl(), array);
        }
        log.info("security info load success!!");
    }


    /**
     * A collection interface that gets access based on the path
     *
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {
        if (map == null) loadResourceDefine();
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        for (String s : map.keySet()) {
            resUrl = s;
            matcher = new AntPathRequestMatcher(resUrl);
            if (matcher.matches(request)) {
                return map.get(resUrl);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
