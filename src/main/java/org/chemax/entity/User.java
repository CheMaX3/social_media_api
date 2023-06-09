package org.chemax.entity;

import org.chemax.dto.PostDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "user_id")
    private Long userId;

    @NotEmpty(message = "Имя пользователя не может быть пустым")
    @Size(min = 4, max = 20, message = "Имя пользователя не может быть короче 4 символов и длиннее 20 символов")
    @Column(name = "username")
    private String username;

    @NotEmpty(message = "Поле электронная почта не может быть пустым")
    @Size(min = 4, max = 50, message = "Электронная почта не может быть короче 4 символов и длиннее 50 символов")
    @Email
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Поле пароля не может быть пустым")
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Transient
    private List<Friend> friendList;

    @Transient
    private List<Subscriber> subscribersList;

    @Transient
    private List<Subscribed> subscribedList;

    @Transient
    private List<FriendshipInvite> friendshipInvitesList;

    @Transient
    private List<PostDTO> posts;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Friend> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<Friend> friendList) {
        this.friendList = friendList;
    }

    public List<Subscriber> getSubscribersList() {
        return subscribersList;
    }

    public void setSubscribersList(List<Subscriber> subscribersList) {
        this.subscribersList = subscribersList;
    }

    public List<Subscribed> getSubscribedList() {
        return subscribedList;
    }

    public void setSubscribedList(List<Subscribed> subscribedList) {
        this.subscribedList = subscribedList;
    }

    public List<FriendshipInvite> getFriendshipInvitesList() {
        return friendshipInvitesList;
    }

    public void setFriendshipInvitesList(List<FriendshipInvite> friendshipInvitesList) {
        this.friendshipInvitesList = friendshipInvitesList;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", friendList=" + friendList +
                ", subscribersList=" + subscribersList +
                ", subscribedList=" + subscribedList +
                ", friendshipInvitesList=" + friendshipInvitesList +
                ", posts=" + posts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(roles, user.roles) && Objects.equals(friendList, user.friendList) && Objects.equals(subscribersList, user.subscribersList) && Objects.equals(subscribedList, user.subscribedList) && Objects.equals(friendshipInvitesList, user.friendshipInvitesList) && Objects.equals(posts, user.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, email, password, roles, friendList, subscribersList, subscribedList, friendshipInvitesList, posts);
    }
}
