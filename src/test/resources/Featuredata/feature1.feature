Feature: Gmail mail compose

  Scenario Outline: 
    Given open "Chrome" Browser page
    When launch site using "http://www.gmail.com"
    When do login using "mayya.rosh1111" and "Apple_123"
    Then compose is displayed
    When click on compose
    Then field should be displayed
    When fill field with "<to>", "<subject>", "<body>" and "<attachment>"
    Then send is enabled
    When click on send
    Then "Message sent" should be displayed
    When do logout
    Then login page should be displayed
    Then closed site

    Examples: 
      | to                    | subject | body         | attachment                     |
      | sahumayuri@gmail.com  | study   | Do your best | D:\\Passport - Mayuri Bedi.pdf |
      #| bedimayuri@gmail.com  | Wishes  | Best Luck    | D:\\Passport - Mayuri Bedi.pdf |
      #| bedi.roshan@gmail.com | CV      | find CV      | D:\\Passport - Mayuri Bedi.pdf |
      
