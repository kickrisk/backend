package com.ssafy.waple.review.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class ReviewDto {

	@ApiModelProperty(value = "리뷰 아이디", example = "1")
	private int reviewId;

	@ApiModelProperty(value = "그룹 아이디", example = "1")
	private int groupId;

	@ApiModelProperty(value = "장소 아이디", example = "19781214")
	private String placeId;

	@ApiModelProperty(value = "회원 아이디", example = "1412733569")
	private long userId;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "방문 일시", example = "2020.07.31")
	private Date visitDate;

	@ApiModelProperty(value = "제목", example = "두부를 사랑하기 시작한 날")
	private String title;

	@ApiModelProperty(value = "내용", example = "두부 진짜 맛있다... 콩 사랑합니다...")
	private String content;

	@ApiModelProperty(value = "미디어 파일", example = "2020.07.31.JPG")
	private String media;

	@ApiModelProperty(value = "작성자", example = "바나나먹는몽키")
	private String userName;

	@ApiModelProperty(value = "그룹 이름", example = "먹방")
	private String groupName;

	@ApiModelProperty(value = "전화번호", example = "02-123-1234")
	private String tel;

	@ApiModelProperty(value = "카테고리", example = "음식점")
	private String category;

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ReviewDto{" +
			"reviewId=" + reviewId +
			", groupId=" + groupId +
			", placeId='" + placeId + '\'' +
			", userId=" + userId +
			", visitDate=" + visitDate +
			", title='" + title + '\'' +
			", content='" + content + '\'' +
			", media='" + media + '\'' +
			", userName='" + userName + '\'' +
			", groupName='" + groupName + '\'' +
			", tel='" + tel + '\'' +
			", category='" + category + '\'' +
			'}';
	}
}
