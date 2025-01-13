package com.EventManagement.model;

public class user {

    private Long userId;

    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;
    private String phoneNumber;

    private Role role;

    private String profilePicture;


    public user(Long userId, String firstName, String lastName, String email, String passwordHash, String phoneNumber,
			Role role, String profilePicture) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passwordHash = passwordHash;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.profilePicture = profilePicture;
	}


	@Override
	public String toString() {
		return "user [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", passwordHash=" + passwordHash + ", phoneNumber=" + phoneNumber + ", role=" + role
				+ ", profilePicture=" + profilePicture + "]";
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPasswordHash() {
		return passwordHash;
	}


	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public String getProfilePicture() {
		return profilePicture;
	}


	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}


	public enum Role {
        ATTENDEE, ORGANIZER, SPEAKER, VENDOR, SPONSOR
    }

    // Getters and setters
}
