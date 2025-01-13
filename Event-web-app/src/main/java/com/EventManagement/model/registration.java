package com.EventManagement.model;

import java.time.LocalDateTime;

public class registration {

    private Long registrationId;

    private user user;

    private event event;

    private String ticketType;
    private Double ticketPrice;
    private LocalDateTime registrationDate;

    private PaymentStatus paymentStatus;

    public registration(Long registrationId, com.EventManagement.model.user user, com.EventManagement.model.event event,
			String ticketType, Double ticketPrice, LocalDateTime registrationDate, PaymentStatus paymentStatus,
			PaymentMethod paymentMethod) {
		super();
		this.registrationId = registrationId;
		this.user = user;
		this.event = event;
		this.ticketType = ticketType;
		this.ticketPrice = ticketPrice;
		this.registrationDate = registrationDate;
		this.paymentStatus = paymentStatus;
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "registration [registrationId=" + registrationId + ", user=" + user + ", event=" + event
				+ ", ticketType=" + ticketType + ", ticketPrice=" + ticketPrice + ", registrationDate="
				+ registrationDate + ", paymentStatus=" + paymentStatus + ", paymentMethod=" + paymentMethod + "]";
	}

	public Long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public event getEvent() {
		return event;
	}

	public void setEvent(event event) {
		this.event = event;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public Double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	private PaymentMethod paymentMethod;

    public enum PaymentStatus {
        PENDING, PAID, REFUNDED
    }

    public enum PaymentMethod {
        CREDIT_CARD, PAYPAL, BANK_TRANSFER
    }

    // Getters and setters
}
