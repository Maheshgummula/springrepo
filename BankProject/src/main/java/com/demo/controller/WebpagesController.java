package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebpagesController {
	@GetMapping("/register")
	public String getRegister() {
		return "customerpages/CustomerRegistrationPage";
	}

	@GetMapping("/getLogout")
	public String getLogout() {
		return "Logoutsuccess";
	}

	@GetMapping("customer/getbalancepage")
	public String getBalances() {
		return "customerpages/ShowBalance";
	}

	@GetMapping("customer/getwithdrawpage")
	public String getWithdraw() {
		return "customerpages/Withdraw";
	}

	@GetMapping("customer/getdepositpage")
	public String getDeposit() {
		return "customerpages/Deposit";
	}

	@GetMapping("/customer")
	public String gethomepage() {
		return "customerpages/HomeCustomer";
	}

	@GetMapping("emp/delete")
	public String deleteCustomer() {
		return "employeepages/DeleteCustomer";
	}

	@GetMapping("admin/registeremp")
	public String getRegisterPage() {
		return "adminpages/EmployeeRegistration";
	}

	@GetMapping("emp/gettotalpage")
	public String getTotalPage() {
		return "employeepages/TotalBalance";
	}

	@GetMapping("admin/deleteemppage")
	public String deleteEmp() {
		return "adminpages/DeleteEmployee";
	}

	@GetMapping("admin/empcustpage")
	public String getEmployeeAndCustomer() {
		return "adminpages/EmployeeCustomerPage";
	}

	@GetMapping("/emp")
	public String gethomepageEmp() {
		return "employeepages/HomeEmployee";
	}

	@GetMapping("/admin")
	public String gethomepageAdmin() {
		return "adminpages/HomeAdmin";
	}

	@GetMapping("/defaultwelcome")
	public String getDefaultWelcome() {
		return "DefaultWelcome";
	}

}
