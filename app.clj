(ns story-game
  (:gen-class))

(defn prompt [message]
  (println message)
  (read-line))

(defn start []
  (let [name (prompt "Welcome to the story game! What is your name?")
        gender (prompt (str "Hi, " name "! Are you a boy or a girl?"))
        appearance (prompt (str "What do you look like?"))
        background (prompt (str "Tell me a little bit about your background."))
        weapon (prompt (str "Choose your weapon: sword, bow and arrow, or staff?"))
        armor (prompt (str "Choose your armor: leather, chainmail, or plate?"))]
    (let [choice1 (prompt (str "You are walking through a dark forest when you come across a fork in the road. " 
                               "Do you want to go left or right?"))
          choice2 (if (= choice1 "left")
                    (prompt "You come across a river. Do you want to swim across or find a bridge?")
                    (prompt "You come across a clearing. Do you want to rest or keep moving?"))]
      (if (= choice2 "swim across")
        (do (println "As you swim across the river, you suddenly feel something brush against your leg. You look down and see a school of piranhas!")
            (if (< (rand) 0.5)
              (do (println "You manage to swim to the other side unharmed.")
                  (let [choice3 (prompt "You reach the other side and find a treasure chest. Do you want to open it or leave it?")]
                    (if (= choice3 "open it")
                      (println (str "You open the treasure chest and find a map that leads to a hidden cave full of gold. Congratulations, " name "! You win!"))
                      (println (str "You continue walking and eventually find your way out of the forest. Better luck next time, " name ".")))))
              (do (println "The piranhas attack you and you are unable to escape. You have died.")
                  (System/exit 0))))
        (let [choice3 (prompt "You continue walking and find a village. Do you want to explore or keep moving?")]
          (if (= choice3 "explore")
            (do (println "As you explore the village, you hear a loud explosion. You run towards the sound and see that a nearby building is on fire!")
                (if (< (rand) 0.5)
                  (do (println "You manage to put out the fire and save the building.")
                      (println (str "Congratulations, " name "! You have saved the day!")))
                  (do (println "Despite your best efforts, the fire continues to spread and consumes the entire village.")
                      (println (str "You were unable to save the village. Better luck next time, " name ".")))))
            (do (println "You continue walking and suddenly hear a loud roar behind you. You turn around and see a T-Rex charging towards you!")
                (let [fight_choice (prompt "Do you want to fight or run away?")]
                  (if (= fight_choice "fight")
                    (if (< (rand) 0.5)
                      (do (println "You manage to defeat the T-Rex with your superior combat skills. Congratulations, " name "! You win!")
                          (System/exit 0))
                      (do (println "The T-Rex proves to be too strong for you and you are unable to defeat it. You have died.")
                          (System/exit 0)))
                    (do (println "You try to run away from the T-Rex, but it catches up to you and devours you whole. You have died.")
                        (System/exit 0)))))))))))

(defn -main []
  (start))
