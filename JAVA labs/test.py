class Category:

  #requires name instance to make it easier to access objects names when referencing
  def __init__(self,name):
    self.ledger = []
    self.name = name
    self.funds = 0

  def check_funds(self,amount):
    if amount>self.funds:
      return False
    return True

  def deposit(self,amount,description=''):
    self.ledger.append({"amount": amount,"description":description})
    self.funds+=float(amount)

  def withdraw(self,amount,description=''):
    if self.check_funds(amount):
      self.ledger.append({"amount": -amount,"description":description})
      self.funds-=float(amount)
      return True
    return False

  def get_balance(self):
    return self.funds

  def transfer(self,amount, category):
    if self.check_funds(amount):
      self.withdraw(amount,"Transfer to "+category.name)
      category.deposit(amount,"Transfer from "+self.name)
      
      return True
    return False

  #print function called __str__ method of an object,
  #by default __str__ returns the object address string
  #we override it to make an object print whatever we want when print() is called on it
  def __str__(self):
    print(f"{self.name:#^30}")
    for item in self.ledger:
        print("{0:<23} {1:>7.2f}".format(item["description"],item["amount"]))
    return f"Total: {self.funds:.2f}"

if __name__=="__main__":
  
  #testing stuff
  Food = Category("Food")
  Chilre = Category("Chilre")

  Food.deposit(1000,"initial deposit")
  Food.withdraw(500,"marriage celebrations")
  Food.transfer(100, Chilre)

  Chilre.deposit(1000,"initial deposit")
  Chilre.withdraw(500,"marriage celebrations")
  Chilre.transfer(100, Chilre)


  print(Food)

  
  #create_spend_chart([Food,Chilre])



def create_spend_chart(cat_list):
    withdraw_sum = 0
    cat_percent = []
    for cat in cat_list:
        cat_sum = 0
        cat_ledge = cat.ledger
        for dick in cat_ledge:
            if dick["amount"]<0:
                withdraw_sum+=dick["amount"]
                cat_sum +=dick["amount"]
        cat_percent.append(cat_sum)
    
    cat_percent = [x/withdraw_sum*100 for x in cat_percent]
    #TODO only prints the list of percentages - need to create the dumbass chart
    print(cat_percent)




