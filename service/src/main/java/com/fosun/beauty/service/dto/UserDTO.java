package com.fosun.beauty.service.dto;

import com.fosun.beauty.common.config.Constants;
import com.fosun.beauty.domain.User;
import com.fosun.beauty.domain.enumeration.SexEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO representing a user, with his authorities.
 */
@ApiModel(description = "操作员")
public class UserDTO {

    private Long id;
    @ApiModelProperty("操作员姓名")

    private String userName;
    @ApiModelProperty("账号")
    @NotBlank
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
    private String login;
    @Size(max = 256)
    @ApiModelProperty("用户头像")
    private String imageUrl;
    @ApiModelProperty("手机号")
    private String mobile;
    @Email
    @Size(min = 5, max = 254)
    private String email;
    @ApiModelProperty("性别")
    private SexEnum sex;
    @ApiModelProperty("生日")
    private Instant birthday;
    @ApiModelProperty("状态")
    private boolean activated = false;
    @ApiModelProperty("角色")
    private Set<Long> roles;
//    @ApiModelProperty("权限")
//    private Set<String> authorities;
    @ApiModelProperty("创建人")
    private String createdBy;
    @ApiModelProperty("创建时间")
    private Instant createdDate;
    @ApiModelProperty("最后修改人")
    private String lastModifiedBy;
    @ApiModelProperty("最后修改时间")
    private Instant lastModifiedDate;
    @Size(min = 2, max = 5)
    @ApiModelProperty("语言")
    private String langKey;

    // private Set<String> authorities;

    public UserDTO() {
        // Empty constructor needed for MapStruct.
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.activated = user.getActivated();
        this.imageUrl = user.getImageUrl();
        this.langKey = user.getLangKey();
        this.createdBy = user.getCreatedBy();
        this.createdDate = user.getCreatedDate();
        this.lastModifiedBy = user.getLastModifiedBy();
        this.lastModifiedDate = user.getLastModifiedDate();
//        this.authorities = user.getAuthorities().stream()
//                .map(Authority::getName)
//                .collect(Collectors.toSet());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getLangKey() {
        return langKey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Instant getBirthday() {
        return birthday;
    }

    public void setBirthday(Instant birthday) {
        this.birthday = birthday;
    }

    public Set<Long> getRoles() {
        return roles;
    }

    public void setRoles(Set<Long> roles) {
        this.roles = roles;
    }

//    public Set<String> getAuthorities() {
//        return authorities;
//    }

//    public void setAuthorities(Set<String> authorities) {
//        this.authorities = authorities;
//    }
}
