/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.perficient.CustomerRelationshipExample;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

    private final Map<String, Customer> customers = new HashMap<>();

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String id) {
        Customer customer = customers.get(id);
        System.out.println("Retrieved customer by id " + id + ") " + customer);

        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer createCustomer) {
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID().toString());
        customer.setName(createCustomer.getName());
        customer.setRating(createCustomer.getRating());
        customer.setComments(createCustomer.getComments());
        customers.put(customer.getId(), customer);
        customerService.createCustomer(customer);
        System.out.println("Created customer " + customer);
        return customer;
    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable String id, @RequestBody Customer updateCustomer) {
        Customer customer = customers.get(id);
        customer.setName(updateCustomer.getName());
        customer.setRating(updateCustomer.getRating());
        customer.setComments(updateCustomer.getComments());
        customerService.createCustomer(customer);
        System.out.println("Updated customer to " + customer);
        return customer;
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity deleteCustomer(@PathVariable String id) {
        Customer customer = customers.get(id);
        customerService.deleteCustomer(customer);
        System.out.println("Deleted customer " + customer);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    
    @PostMapping("/customers/merge/{id}")
    public Customer mergeCustomer(@PathVariable String id, @RequestParam List<Customer> mergeCustomers) {
    	 Customer customer = customers.get(id);
         System.out.println("Existing customer by id " + id + ") " + customer);
        return customer;
    }

}