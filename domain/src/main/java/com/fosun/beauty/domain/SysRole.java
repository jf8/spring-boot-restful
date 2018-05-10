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
 * 用户角色
 */
@ApiModel(description = "操作员角色")
@Entity
@Table(name = "sys_role")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SysRole extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @ApiModelProperty("角色名称")
    private String name;

    @Column(name = "description")
    @ApiModelProperty("角色描述")
    private String description;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "sys_role_sys_resources",
               joinColumns = @JoinColumn(name="sys_roles_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="sys_resources_id", referencedColumnName="id"))
    private Set<SysResource> sysResources = new HashSet<>();


    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<User> users = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public SysRole name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public SysRole description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<SysResource> getSysResources() {
        return sysResources;
    }

    public SysRole sysResources(Set<SysResource> sysResources) {
        this.sysResources = sysResources;
        return this;
    }

    public SysRole addSysResources(SysResource sysResource) {
        this.sysResources.add(sysResource);
        sysResource.getSysRoles().add(this);
        return this;
    }

    public SysRole removeSysResources(SysResource sysResource) {
        this.sysResources.remove(sysResource);
        sysResource.getSysRoles().remove(this);
        return this;
    }


    public Set<User> getUsers() {
        return users;
    }

    public SysRole users(Set<User> users) {
        this.users = users;
        return this;
    }

    public SysRole addUsers(User user) {
        this.users.add(user);
        user.getRoles().add(this);
        return this;
    }

    public SysRole removeUsers(User user) {
        this.users.remove(user);
        user.getRoles().remove(this);
        return this;
    }



    public void setSysResources(Set<SysResource> sysResources) {
        this.sysResources = sysResources;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SysRole sysRole = (SysRole) o;
        if (sysRole.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, sysRole.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "SysRole{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", description='" + description + "'" +
            '}';
    }
}
