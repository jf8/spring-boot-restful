package com.fosun.beauty.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 用户资源
 */
@ApiModel(description = "用户资源")
@Entity
@Table(name = "sys_resource")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SysResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @ApiModelProperty("权限")
    private String name;

    @Column(name = "description")
    @ApiModelProperty("权限描述")
    private String description;

    @Column(name = "url")
    @ApiModelProperty("权限绑定的URL")
    private String url;

    @Column(name = "pid")
    @ApiModelProperty("父节点ID")
    private Long pid;

    @ManyToMany(mappedBy = "sysResources")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<SysRole> sysRoles = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public SysResource name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public SysResource description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public SysResource url(String url) {
        this.url = url;
        return this;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getPid() {
        return pid;
    }

    public SysResource pid(Long pid) {
        this.pid = pid;
        return this;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Set<SysRole> getSysRoles() {
        return sysRoles;
    }

    public SysResource sysRoles(Set<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
        return this;
    }

    public SysResource addSysRoles(SysRole sysRole) {
        this.sysRoles.add(sysRole);
        sysRole.getSysResources().add(this);
        return this;
    }

    public SysResource removeSysRoles(SysRole sysRole) {
        this.sysRoles.remove(sysRole);
        sysRole.getSysResources().remove(this);
        return this;
    }

    public void setSysRoles(Set<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SysResource sysResource = (SysResource) o;
        if (sysResource.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, sysResource.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "SysResource{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", description='" + description + "'" +
            ", url='" + url + "'" +
            ", pid='" + pid + "'" +
            '}';
    }
}
