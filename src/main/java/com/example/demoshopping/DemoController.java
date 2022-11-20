package com.example.demoshopping;

import com.example.demoshopping.entity.Customer;
import com.example.demoshopping.entity.Orders;
import com.example.demoshopping.entity.Products;
import com.example.demoshopping.repository.CustomerRepositor;
import com.example.demoshopping.repository.OrdersRepository;
import com.example.demoshopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class DemoController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepositor customerRepository;
    @Autowired
    private OrdersRepository ordersRepository;

    @RequestMapping(value = "/getproductbyname", params = {"name"}, method = GET)
    public String getProductByname(@RequestParam("name") String name) {
        List<Products> productslist = productRepository.findByproductName(name);

        return productslist.toString();
    }

    @RequestMapping(value = "/getproductbyId", params = {"id"}, method = GET)
    public List<Products> getProductByID(@RequestParam("id") Long id) {
        List<Products> productslist = productRepository.findByProductId(id);
        return productslist;
    }


    @RequestMapping(value = "/saveproduct", method = GET)
    public String getsaveProduct(@RequestParam("name") String name, @RequestParam("price") double price, @RequestParam("desc") String desc, @RequestParam(value = "quantity") int quantity) {
        Products products = Products.builder().productName(name).price(price).Description(desc).Quantity(quantity).build();
        productRepository.save(products);
        return products.toString();
    }

    @RequestMapping(value = "/savecustomer", method = GET)
    public String getSaveCustomer(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname, @RequestParam("email") String emailId, @RequestParam("phone") String phone) {
        Customer customer = Customer.builder().firstName(firstname).lastName(lastname).emailId(emailId).phone(phone).build();
        customerRepository.save(customer);
        return customer.toString();
    }

    @RequestMapping(value = "/getcustomerbyemail", params = {"email"}, method = GET)
    public String getCustomerbyemailid(@RequestParam("email") String email) {
        List<Customer> customerList = customerRepository.findByemailId(email);
        return customerList.toString();
    }

    @RequestMapping(value = "/createorder", method = GET)
    public String getCreateOrder(@RequestParam("products") String productids, @RequestParam("quantitys") String quantitys, @RequestParam("customerid") Long customerid) {
        Double total = 0.00;
        String[] arrOfproductids = productids.split(",");
        String[] arrOfquantitys = quantitys.split(",");

        for (int i = 0; i < arrOfproductids.length; i++) {
            double price = getProductByID(Long.parseLong(arrOfproductids[i])).get(0).getPrice();
            total = total + (price * Double.parseDouble(arrOfquantitys[i]));
        }
        Orders orders = Orders.builder().productId(productids).Quantity(quantitys).customer_id(customerid).total(total).orderStatus("PENDING").build();
        ordersRepository.save(orders);
        return orders.toString();
    }

    @RequestMapping(value = "/getorder", method = GET)
    public String getorder(@RequestParam("orderId") Long orderId) {
        List<Orders> ordersList = ordersRepository.findByorderId(orderId);
        return ordersList.toString();
    }

    @RequestMapping(value = "/updateOrderStatus", method = GET)
    public void updateOrderStatus(@RequestParam("orderStatus") String orderStatus, @RequestParam("orderId") Long orderId) {
        int status = ordersRepository.updateOrderStatusByOrderID(orderStatus, orderId);
    }
}
