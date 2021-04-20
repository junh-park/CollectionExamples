package com.jun.helpdesk;

import static com.jun.helpdesk.Category.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Predicate;

public class HelpDesk {

	private final Queue<Enquiry> enquiries = new ArrayDeque<Enquiry>();

//	public void enquire(final Customer customer, final Category category) {
//		enquiries.offer(new Enquiry(customer, category));
//	}
	
	public boolean enquire(final Customer customer, final Category category) {
		return enquiries.offer(new Enquiry(customer, category));
	}

//	public void processAllEnquiries() {
//
//		Enquiry enquiry;
//		
//		while ((enquiry = enquiries.poll()) != null) {
//			enquiry.getCustomer().reply("Have you tried turning it off and on again?");
//		}
//	}
	
	public void processPrinterEnquiry() {
		processEnquiry("Is it out of paper?", enq -> enq.getCategory() == PRINTER);
	}
	
	public void processGeneralEnquiry() {
//		final String message = "Have you tried turning it off and on again?";
//		Java8 feature lambda function
//		final Predicate<Enquiry> predicate = enq -> enq.getCategory() != PRINTER;
		processEnquiry("Have you tried turning it off and on again?", 
				enq -> enq.getCategory() != PRINTER);
	}

	private void processEnquiry(final String message, final Predicate<Enquiry> predicate) {
		final Enquiry enquiry = enquiries.peek();
		if(enquiry != null && predicate.test(enquiry)) {
			enquiries.remove();
			enquiry.getCustomer().reply(message);
		}
		else {
			System.out.println("No work to do, let's have some coffee!");
		}
	}
	
	public static void main(String[] args) {

		HelpDesk helpDesk = new HelpDesk();
		helpDesk.enquire(Customer.JACK, Category.PHONE);
		helpDesk.enquire(Customer.JILL, Category.PRINTER);

		helpDesk.processPrinterEnquiry();
		helpDesk.processGeneralEnquiry();
		helpDesk.processPrinterEnquiry();
	}
}
