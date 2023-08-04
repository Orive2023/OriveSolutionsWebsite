package com.orive.OriveContactForm.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "contact_details")
public class ContactDetails implements Serializable{

	@Id
	@GenericGenerator(name = "auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "contactId")
	private Long contactId;
	
	
	@NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between {min} and {max} characters long")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name must contain only alphabetic characters")
	@Column(name = "firstName")
	private String firstName;
	
	
	@NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between {min} and {max} characters long")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name must contain only alphabetic characters")
	@Column(name = "lastName")
	private String lastName;
	
	@NotBlank
	@Email(message = "It is in email format")
	@Column(name = "emailAddress")
	private String emailAddress;
	
	@NotNull
	@Column(name = "phoneNumber")
	private Long phoneNumber;
	
	@Size(min = 2, max = 500, message = "Message must be between {min} and {max} characters long")
	@NotBlank(message = "Write a message")
	@Column(name = "writeMessage")
	private String writeMessage;
	
	@Column(name = "organisationName")
	private String organisationName;

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "save_date")
    private Date saveDate;

    @PrePersist
    protected void onCreate() {
        saveDate = new Date();
    }
}
