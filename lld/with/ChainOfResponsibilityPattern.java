abstract class SupportHandler {
    protected SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(String issueType);
}

class ChatbotSupport extends SupportHandler {

    @Override
    public void handleRequest(String issueType) {
        if(issueType.equals("basic")) {
            System.out.println("Chat bot is in assistant");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(issueType);
        }
    }
}

class CustomerSupport extends SupportHandler {

    @Override
    public void handleRequest(String issueType) {
        if(issueType.equals("moderate")) {
            System.out.println("Agent is in assistant");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(issueType);
        }
    }
}

class ManagerSupport extends SupportHandler {

    @Override
    public void handleRequest(String issueType) {
        if(issueType.equals("serious")) {
            System.out.println("Manager is in assistant");
        } else {
            System.out.println("No support available");
        }
    }
}

public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        SupportHandler chatbot = new ChatbotSupport();
        SupportHandler agent = new CustomerSupport();
        SupportHandler manager = new ManagerSupport();

        chatbot.setNextHandler(agent);
        agent.setNextHandler(manager);

        chatbot.handleRequest("basic");
        chatbot.handleRequest("serious");
        chatbot.handleRequest("moderate");
        chatbot.handleRequest("invalid");
    }
}
