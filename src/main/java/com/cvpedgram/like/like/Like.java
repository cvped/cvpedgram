package com.cvpedgram.like.like;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@Builder
@Table(name="like")
@Entity
public class Like {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	@Column(name="postId")
	private int postId;
	@Column(name="userId")
	private int userId;
	@Column(name="createAt")	
	@CreationTimestamp
	private  LocalDateTime createAt;
	
	
}
