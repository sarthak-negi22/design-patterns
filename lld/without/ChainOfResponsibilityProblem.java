class CustomerSupport {
    public void handleRequest(String issue) {
        if (issue.equalsIgnoreCase("basic")) {
            System.out.println("Chatbot: Handling basic inquiry");
        } else if (issue.equalsIgnoreCase("moderate")) {
            System.out.println("Support Agent: Handling moderate issue");
        } else if (issue.equalsIgnoreCase("serious")) {
            System.out.println("Manager: Handling serious complaint");
        } else {
            System.out.println("No handler available for this issue");
        }
    }
}

public class ChainOfResponsibilityProblem {
    public static void main(String[] args) {
        CustomerSupport support = new CustomerSupport();
        support.handleRequest("basic");
        support.handleRequest("moderate");
        support.handleRequest("serious");
    }
}

