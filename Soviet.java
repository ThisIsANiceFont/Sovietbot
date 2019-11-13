
/**
 * Sovietbot is a chatbot who is a very bad Soviet spy in the early 1990s, 
 * who hasn’t realized that the Soviet Union split up yet. This class defines
 * all of it's greetings, responses, and special responses using its special
 * methods. Based off the Magpie Activity in CSA.
 *
 * @author Gene Pan, Rupali Sarathy
 * @version 1.0
 */
public class Soviet
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Привет… I mean, hello!";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        //hello responses
        if (findKeyword(statement, "Hello") >= 0
                || findKeyword(statement, "Hi") >= 0
                || findKeyword(statement, "Hey") >= 0
                || findKeyword(statement, "What's up") >= 0)
        {
            response = "До́брое у́тро. Tell me information capitalist";
        }
        //contains this keyword, then say this responses
        else if (statement.indexOf("Stalin") >= 0)
        {
            response = "Us fellow Americans, we think wrong about Stalin, don’t you think?";
        }
        else if (statement.indexOf("Reagan") >= 0)
        {
            response = "He ruined everything! Walls kept the world safe.";
        }
        else if (statement.indexOf("suspicious") >= 0)
        {
            response = "Me? How dare you!";
        }
        else if (statement.indexOf("Cuba") >= 0)
        {
            response = "Can you believe us patriotic Americans attacked Russia’s autonomy to put missiles where they want?";
        }
        else if (findKeyword(statement, "Cold War") >= 0)
        {
            response = "We are all Americans here, of course. But, between you and me, it seems like the Soviets will win!";
        }
        else if (findKeyword(statement, "believe", 0) >= 0 && findKeyword(statement, "?", 0) >= 0)
        {
            response = "I believe in… Well, there’s no good word for it. It’s called Коммунизм.";
        }
        else if (findKeyword(statement, "hate", 0) >= 0)
        {
            response = "I certainly hate you.";
        }
        else if (findKeyword(statement, "like", 0) >= 0)
        {
            response = "I certainly do not like you.";
        }
        else if (findKeyword(statement, "spy", 0) >= 0)
        {
            response = "Are you accusing me of espionage? How dare you!";
        }
        else if (findKeyword(statement, "Russian", 0) >= 0)
        {
            response = "Привет изменник.";
        }
        else if (findKeyword(statement, "Gorbachev", 0) >= 0)
        {
            response = "He’s ruining us! He’s making us weak! That изменник.";
        }
        else if (findKeyword(statement, "anthem", 0) >= 0)
        {
            response = "I’ve memorized the American anthem, but there’s something majestic about the Soviet’s.";
        }
        else if (findKeyword(statement, "Bay of Pigs", 0) >= 0)
        {
            response = "The Americans, as always, taking another country’s autonomy.";
        }
        else if (findKeyword(statement, "Vietnam", 0) >= 0)
        {
            response = "TWe got what we were coming for there… and I can say that without even being Communist!";
        }
        else if (findKeyword(statement, "Language", 0) >= 0)
        {
            response = "I can speak English with an accent, but of course Russian is the best.";
        }
        else if (findKeyword(statement, "Nicaragua", 0) >= 0)
        {
            response = "Reagan showed his true colors there… much like every American leader. The people are too blind to see the truth.";
        }
        else if (findKeyword(statement, "Lenin", 0) >= 0)
        {
            response = "Good Lenin. Died knowing the future of his nation was safe.";
        }
        else if (findKeyword(statement, "Marx", 0) >= 0)
        {
            response = "Did you know: he is considered one of the greatest economists in history! Only propaganda says otherwise.";
        }
        else if (findKeyword(statement, "Where") >= 0
                && findKeyword(statement, "you") >= 0)
        {
            response = "I’m from the glorious motherland… of Connecticut of course. I am pure American.";
        }
        else if (findKeyword(statement, "hobby") >= 0
                || findKeyword(statement, "hobbies") >= 0)
        {
            response = "Hobbies? Besides the love for my country? Nothing!";
        }
        else if (findKeyword(statement, "Soviet Union", 0) >= 0)
        {
            response = "Isn’t it amazing? Coming from poor, oppressed imperialism to the future of Communism?";
        }
        else if (findKeyword(statement, "Where") >= 0
                && findKeyword(statement, "we") >= 0)
        {
            response = "America. Land of free and hypocrites.";
        }
        else if (findKeyword(statement, "name", 0) >= 0)
        {
            response = "I am Soviet Bot, from the good old Bot family in Michigan.";
        }
        else if (findKeyword(statement, "How are you?", 0) >= 0)
        {
            response = "I am disgusted to be in this capitalistic hell hole.";
        }
        //Method responses
        else if (findKeyword(statement, "What do you think about", 0) >= 0)
        {
            response = transformYouThink(statement);
        }
        else if (findKeyword(statement, "Did you hear about", 0) >= 0)
        {
            response = transformDidYou(statement);
        }
        else if (findKeyword(statement, "Can you", 0) >= 0)
        {
            response = transformCanYou(statement);
        }
        else if (findKeyword(statement, "You are", 0) >= 0)
        {
            response = transformYouAre(statement);
        }
        else if (findKeyword(statement, "Why do you", 0) >= 0)
        {
            response = transformWhyWant(statement);
        }
        else if (findKeyword(statement, "Do you know about", 0) >= 0)
        {
            response = transformKnowAbout(statement);
        }
        else if (findKeyword(statement, "I want to", 0) >= 0)
        {
            response = transformIWantTo(statement);
        }
        else if (findKeyword(statement, "I want", 0) >= 0)
        {
            response = transformIWant(statement);
        }
        else if (statement.isEmpty())
        {
            response = "Hello? American pig?";
        }
        //Final check for pattern, random response for unknowns
        else  
        {
            // Look for a two word (you <something> me) pattern
            int psn = findKeyword(statement, "you", 0);
            if (psn >= 0 && findKeyword(statement, "me", psn) >= 0)
            {
                response = transformYouMeStatement(statement);
            }
            else
            {
                response = getRandomResponse();
            }
       }
       return response;
    }

    /**
     * 
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     * 
     */
    public String transformIWantTo(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "I want to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "Of course. An American would obviously want to " + restOfStatement;
    }
    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWant(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "I want", 0);
        String restOfStatement = statement.substring(psn + 7).trim();
        return "The only " + restOfStatement + " that would make me happy is the " + restOfStatement + " of an equal society.";
    }

    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * Also works if statement is "you <something> me <something else>" and transforms it into
     * "What makes you think that I <something> you <something else>?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        
        int psnOfYou = findKeyword (statement, "you", 0);
        int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);
        
        String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
        String endOfStatement = " " + statement.substring(psnOfMe+2).trim();
        return "Why would I ever " + restOfStatement + " you" + endOfStatement + "?" ;
}

    /**
     * Transforms the user statement “What do you think about (something)?” 
     * and makes it “Me? (something)? You shall not define me.”
     */
    public String transformYouThink(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("?"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        
        int psnOfAbout = findKeyword (statement, "about", 0);
        
        String restOfStatement = statement.substring(psnOfAbout + 5).trim();
        return "I think " + restOfStatement + " proves that capitalism is broken." ;
}
    
    /**
     * Parses for the user statement “Did you hear about (something)?” and responds with 
     * “What about it? Give me information capitalist pig.”
     */
    public String transformDidYou(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("?"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        
        int psnOfAbout = findKeyword (statement, "about", 0);
        
        String restOfStatement = statement.substring(psnOfAbout + 5).trim();
        return "What about " + restOfStatement + "? Give me information capitalist pig." ;
    }
    
    /**
     * Transforms the user statement “Can you (something)?” and makes it 
     * “I refuse to listen to your orders. I will not (something).”
     */
    public String transformCanYou(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("?"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        
        int psnOfYou = findKeyword (statement, "you", 0);
        
        String restOfStatement = statement.substring(psnOfYou + 3).trim();
        return "I refuse to listen to your orders. I will not " + restOfStatement;
    }
    
    /**
     * Transforms the user statement “Do you know about (something)?” and makes it 
     * “(Something)? Seems like American propaganda to me. shall not define me.” Capitalizes the Something.
     */
    public String transformKnowAbout(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("?"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        
        int psnOfAbout = findKeyword (statement, "about", 0);
        
        String restOfStatement = statement.substring(psnOfAbout + 5).trim();
        restOfStatement = restOfStatement.substring(0, 1).toUpperCase() + restOfStatement.substring(1);
        return restOfStatement + "? Seems like American propaganda to me.";
    }
    
    /**
     * Transforms the user statement “You are (something).” and makes it 
     * “Me? (something)? You shall not define me.” Capitalizes the something.
     */
    public String transformYouAre(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        
        int psnOfAre = findKeyword (statement, "are", 0);
        
        String restOfStatement = statement.substring(psnOfAre + 3).trim();
        restOfStatement = restOfStatement.substring(0, 1).toUpperCase() + restOfStatement.substring(1);
        return "Me? " + restOfStatement + "? You shall not define me.";
    }
    
    /**
     * Parses for the user statement “Why do you want (something)?” and responds with 
     * “I just want information… to… spread capitalism.”
     */
    public String transformWhyWant(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("?"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        
        int psnOfWant = findKeyword (statement, "want", 0);
        
        String restOfStatement = statement.substring(psnOfWant + 4).trim();
        return "I just want " + restOfStatement + "… to… spread capitalism.";
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    public String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Привет как дела";
        }
        else if (whichResponse == 1)
        {
            response = "что происходит";
        }
        else if (whichResponse == 2)
        {
            response = "вам понравилась еда";
        }
        else if (whichResponse == 3)
        {
            response = "как поживает твой брат";
        }
        else if (whichResponse == 4)
        {
            response = "ты глупый";
        }
        else if (whichResponse == 5)
        {
            response = "Wow, I didn't know about that.";
        }

        return response;
    }
    
    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no").
     * 
     * @param statement
     *            the string to search
     * @param goal
     *            the string to search for
     * @param startPos
     *            the character of the string to begin the
     *            search at
     * @return the index of the first occurrence of goal in
     *         statement or -1 if it's not found
     */
    public int findKeyword(String statement, String goal,
    int startPos)
    {
        String phrase = statement.trim();
        // The only change to incorporate the startPos is in
        // the line below
        int psn = phrase.toLowerCase().indexOf(
                goal.toLowerCase(), startPos);

        // Refinement--make sure the goal isn't part of a
        // word
        while (psn >= 0)
        {
            // Find the string of length 1 before and after
            // the word
            String before = " ", after = " ";
            if (psn > 0)
            {
                before = phrase.substring(psn - 1, psn)
                .toLowerCase();
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(
                    psn + goal.length(),
                    psn + goal.length() + 1)
                .toLowerCase();
            }
            
            // If before and after aren't letters, we've
            // found the word
            if (((before.compareTo("a") < 0) || (before
                    .compareTo("z") > 0)) // before is not a
                // letter
            && ((after.compareTo("a") < 0) || (after
                    .compareTo("z") > 0)))
            {
                return psn;
            }

            // The last position didn't work, so let's find
            // the next, if there is one.
            psn = phrase.indexOf(goal.toLowerCase(),
                psn + 1);

        }

        return -1;
    }
    
    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no"). The search
     * begins at the beginning of the string.
     * 
     * @param statement
     *            the string to search
     * @param goal
     *            the string to search for
     * @return the index of the first occurrence of goal in
     *         statement or -1 if it's not found
     */
    public int findKeyword(String statement, String goal)
    {
        return findKeyword(statement, goal, 0);
    }
}
