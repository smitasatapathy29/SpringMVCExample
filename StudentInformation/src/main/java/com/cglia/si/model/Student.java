package com.cglia.si.model;
public class Student {
    
	private Integer id;
	private String name;
    private String email;
    private String gender;
   // private String dob;
    private String fatherName;
    private String motherName;
    private Long mobile;
    private String address;
    

    public Student( Integer id, String name, String email, String gender, String dob, String fatherName, String motherName,
			Long mobile, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		//this.dob = dob;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.mobile = mobile;
		this.address = address;
	}

    
	public Student() {
		super();
	}


	// Getters and Setters for all fields
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

   /* public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    */

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
	public String toString() {
		return "Student [id =" + id + " , name=" + name + ", email=" + email + ", gender=" + gender + /*", dob=" + dob + */", fatherName="
				+ fatherName + ", motherName=" + motherName + ", mobile=" + mobile + ", address=" + address + "]";
	}
}
