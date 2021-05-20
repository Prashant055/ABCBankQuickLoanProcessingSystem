package com.capgemini.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.capgemini.entities.CustomerLoanRequest;
import com.capgemini.service.ICustomerLoanRequestService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CustomerLoanRequestController.class)
class CustomerLoanRequestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	// LEARNING 1 :: DUMMY OBJECT :: MOCK OBJECT

	@MockBean
	private ICustomerLoanRequestService icustomerloanrequestservice;

	@Test
	void CustomerfindbyidTest() throws Exception {

		CustomerLoanRequest clr = new CustomerLoanRequest();

		// LEARNING 2
		// providding the implemenation of findById method.
		// mocking the findById method on MockObject employeeService

		Mockito.when(icustomerloanrequestservice.findById(Mockito.anyInt())).thenReturn(clr);

		mockMvc.perform(get("/api/customerloanrequest/3")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	void createCustomerTest() throws Exception {
		CustomerLoanRequest clr = new CustomerLoanRequest();
		clr.setName("Virat");
		clr.setCity("Delhi");

		Mockito.when(icustomerloanrequestservice.addCustomerLoanRequest(Mockito.any())).thenReturn("Added");

		mockMvc.perform(post("/api/customerloanrequest/addloandetails").contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(clr)))
				.andExpect(MockMvcResultMatchers.status().isCreated());
				//.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Virat"));
	}
	
	@Test
	void DeleteEmployeeByIdTest() throws Exception{
		String URI = "/api/customerloanrequest/delete/1";
		CustomerLoanRequest clr = new CustomerLoanRequest();
		clr.setId(3);
		clr.setName("Rohit");
		clr.setEmail("rohit@gmail.com");
		clr.setCity("Chandigarh");
		new ArrayList<>();

		icustomerloanrequestservice.deleteCustomerLoanRequest(clr.getId());
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(org.springframework.http.MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		mockHttpServletResponse.getContentAsString();
	}

}