package org.example.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address{
	private String zipcode;
	private Geo geo;
	private String suite;
	private String city;
	private String street;

}
