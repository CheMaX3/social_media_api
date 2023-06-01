package org.chemax.entity;

import javax.persistence.*;

@Entity
@Table(name = "subscribers")
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column(name = "requester_id")
    private Long requesterId;

    @Column(name = "requested_id")
    private Long requestedId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(Long requesterId) {
        this.requesterId = requesterId;
    }

    public Long getRequestedId() {
        return requestedId;
    }

    public void setRequestedId(Long requestedId) {
        this.requestedId = requestedId;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", requesterId=" + requesterId +
                ", requestedId=" + requestedId +
                '}';
    }
}