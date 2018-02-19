import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter{

    public static void main(String[] args) throws LoginException {

        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = "NDE0NDI2OTg0MTQwMjQyOTQ1.DWxogA.Y-nMEHIJQ_8daY4eS2UTUfdPNno";
        builder.setToken(token);
        builder.addEventListener(new Main());
        builder.buildAsync();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getAuthor().isBot()) return;

        System.out.println("We recieved a message from " +
                event.getAuthor().getName() + ": " +
                event.getMessage().getContentDisplay());
        //lets use raw so we have the content exactly as the user sent it
        if(event.getMessage().getContentRaw().equals("!ping")){
            //remember to call queue()!
            //otherwise our message will never be sent
            event.getChannel().sendMessage("Pong!").queue();
        }
    }
}
