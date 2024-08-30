package sunbase.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import sunbase.exception.CustomerException;
import sunbase.model.Customer;
import sunbase.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Customer addCustomer(Customer customer) {
		customer.setUuid(UUID.randomUUID().toString());

		return customerRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public List<Customer> getListOfCustomer(String sortingField, String value) {
		Sort sort = Sort.by(sortingField).ascending();

		Pageable pageable = PageRequest.of(0, 10, sort);
		Page<Customer> page = null;
		
		if(sortingField.equals("firstName")) {
			page = customerRepo.findByFirstName(value, pageable);
		}
		else if(sortingField.equals("city")) {
			page = customerRepo.findByCity(value, pageable);
		}
		else if(sortingField.equals("email")) {
			page = customerRepo.findByEmail(value, pageable);
		}
		else {
			page = customerRepo.findByPhone(value, pageable);
		}

		return page.getContent();
	}

	@Override
	public Customer getCustomerById(String uuId) throws CustomerException {
		return customerRepo.findById(uuId).orElseThrow(() -> new CustomerException("Invalid Id"));
	}

	@Override
	public Customer deleteCustomerById(String uuId) throws CustomerException {
		Customer customer = getCustomerById(uuId);

		customerRepo.delete(customer);
		return customer;
	}

	@Override
	public List<Customer> syncCustomer() throws IOException {
		String token = getToken();
		System.out.println(token);
		List<Customer> customers=  getCustomerListByRemoteApi(token);
		
		return customerRepo.saveAll(customers);
	}

	private String getToken() throws IOException {
		Map<String, Object> map = new HashMap<>();
	    ObjectMapper objectMapper = new ObjectMapper();

	    map.put("login_id", "test@sunbasedata.com");
	    map.put("password", "Test@123");

	    String data = objectMapper.writeValueAsString(map);

	    OkHttpClient client = new OkHttpClient().newBuilder().build();
	    MediaType mediaType = MediaType.parse("application/json");

	    RequestBody body = RequestBody.create(mediaType, data);

	    Request request = new Request.Builder()
	        .url("https://qa.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp")
	        .method("POST", body)
	        .addHeader("Content-Type", "application/json")
	        .build();
		
		Response response = client.newCall(request).execute();
		
		String responseBody = response.body().string();

		Map<String, String> responseMap = objectMapper.readValue(responseBody, new TypeReference<Map<String, String>>() {});
		String accessToken = responseMap.get("access_token");
		
		return accessToken;
	}

	private List<Customer> getCustomerListByRemoteApi(String token) throws IOException {
		OkHttpClient client = new OkHttpClient().newBuilder().build();

		MediaType mediaType = MediaType.parse("text/plain");

		RequestBody body = RequestBody.create(mediaType, "");

		Request request = new Request.Builder()
				.url("https://qa.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=get_customer_list")
				.addHeader("Authorization", "Bearer " + token).build();

		Response response = client.newCall(request).execute();

		ObjectMapper objectMapper = new ObjectMapper();

		return objectMapper.readValue(response.body().string(), new TypeReference<List<Customer>>() {
		});
	}

	@Override
	public List<Customer> getAllCustomer() {
		Pageable pageable = PageRequest.of(0, 10);
		Page<Customer> page = customerRepo.findAll(pageable);
		
		return page.getContent();
	}
}