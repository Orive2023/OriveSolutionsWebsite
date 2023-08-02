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
	
	
	@NotBlank(message = "First Name can not blank")
	@Size(min = 2,max = 20)
	@Column(name = "firstName")
	private String firstName;
	
	
	@NotBlank(message = "Last Name can not blank")
	@Size(min = 2,max = 20)
	@Column(name = "lastName")
	private String lastName;
	
	@NotBlank
	@Email(message = "It is in email format")
	@Column(name = "emailAddress")
	private String emailAddress;
	
	@NotBlank
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@NotNull
	@NotBlank(message = "give message")
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
