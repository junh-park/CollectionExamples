package com.jun.helpdesk;

import static com.jun.helpdesk.Category.*;
import static com.jun.helpdesk.Customer.*;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Predicate;

public class PriorityHelpDesk {
	
	//whenever implementing priority queue or treeset, 
	//use comparator after implementing it
	//when using enum, compare method can take enum and compare the order based on the order
	//element is entered in enum class
	private static final Comparator<Enquiry> BY_CATEGORY = new Comparator<Enquiry>() {
		public int compare(Enquiry o1, Enquiry o2) {
			return o1.getCategory().compareTo(o2.getCategory());
		}; 
	};
	
	//put comparator in the constructor
	private final Queue<Enquiry> enquiries = new PriorityQueue<Enquiry>(BY_CATEGORY);

	public boolean enquire(final Customer customer, final Category category) {
		return enquiries.offer(new Enquiry(customer, category));
	}
	
	public void processAllEnquiries() {
		Enquiry enquiry;
		
		while ((enquiry = enquiries.poll()) != null) {
			enquiry.getCustomer().reply("Have you tried turning it off and on again?");
		}
	}
	
	public void processPrinterEnquiry() {
		processEnquiry("Is it out of paper?", enq -> enq.getCategory() == PRINTER);
	}
	
	public void processGeneralEnquiry() {
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

		PriorityHelpDesk helpDesk = new PriorityHelpDesk();
		
		helpDesk.enquire(JACK, PHONE);
		helpDesk.enquire(JILL, PRINTER);
		helpDesk.enquire(MARY, COMPUTER);

		helpDesk.processAllEnquiries();
	}
}
