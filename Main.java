import javax.security.auth.login.LoginException;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Main extends ListenerAdapter {

	public static void main(String[] args) throws LoginException, IllegalArgumentException, InterruptedException, RateLimitedException {
			JDA api = new JDABuilder(AccountType.BOT).setToken("NTE5NjIzODQ4NTY0NjIxMzEz.DuiFnw.Cx2GmZXqJh69ChMdpfXIf3pULV4").build();
			api.addEventListener(new Main());
	}
	
	public void onMessageReceived(MessageReceivedEvent event) {
		if (event.getAuthor().isBot()) return;
		
		Message message = event.getMessage();
		MessageChannel channel = event.getChannel();
		User user = event.getAuthor();
		
		//Responds only if a message begins with "!"
		if (message.getContentRaw().charAt(0) == '!') {
			String[] strArgs = message.getContentRaw().substring(1).split(" ");
			
			//Responds to "!hello"
			if (strArgs[0].equals("hello")) {
				channel.sendMessage("Hello " + user.getAsMention()).queue();
			} else if (strArgs[0].equals("roll")) { 
				int rollSides = 6;
				
				//Checks if there's something after the initial request
				if(strArgs.length > 1) {
					rollSides = Integer.valueOf(strArgs[1]);
				}
				channel.sendMessage("You rolled a " + (int)(Math.random() * rollSides + 1)).queue();
			} else if (strArgs[0].equals("yeet")) { 
				channel.sendMessage("YEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEET").queue();
			} else if (strArgs[0].equals("help")) { 
				String response = getRandomNo();
				channel.sendMessage(response).queue();
			} else if (event.getMessage().getContentRaw().toLowerCase().contains("make me mod")) { 
				channel.sendMessage("No").queue();
			}			
		} else if (event.getMessage().getContentRaw().toLowerCase().contains("make me mod")) { 
			channel.sendMessage("No").queue();
		}
	}
	private String getRandomNo()
	{
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		if (whichResponse == 0) {
			response = "No lol";
		}
		else if (whichResponse == 1) {
			response = "Why are you asking me?";
		}
		else if (whichResponse == 2) {
			response = "Ask nicer";
		}
		else if (whichResponse == 3) {
			response = "Do you really think I know?";
		}
		return response;
	}
}
