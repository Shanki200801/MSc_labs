import math

class Category:

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

  def __str__(self):
        string = ''
        string+=f"{self.name:*^30}"
        for item in self.ledger:
            string+="\n{0:<23} {1:.2f}".format(item["description"][0:23],item["amount"])[:31]
        string += f"\nTotal: {self.funds}"
        return string

Food = Category("Food")
Chilre = Category("Chilre")

Food.deposit(1000,"initial deposit")
Food.withdraw(500,"marriage celebrationssssssssss")
Food.transfer(100, Chilre)

Chilre.deposit(1000,"initial deposit")
Chilre.withdraw(555,"marriage celebrations")
Chilre.transfer(100, Chilre)


print(Food)

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


    
    cat_percent = [round(num,-1) for num in cat_percent]

    stringg = ''
    stringg+="Percentage spent by category"
    for i in range(100,-1,-10):
        string = ''
        for percent in cat_percent:
            if percent >= i:
                string+=' o '
            else:
                string += '   '
        stringg+='\n{:>3}|'.format(i)+string
    stringg+='\n    '+'-'*((2*len(cat_percent))+4)
    return stringg
    
    def max_len(cat_list):
        words= []
        for cat in cat_list:
            words.append(cat.name)
        max_word = max(words,key=len)
        return len(max_word)
    
    
    for i in range(max_len(cat_list)):
        print('    ',end=' ')
        for x in cat_list:
            if len(x.name)<=i: 
                print(' ',end=' ')
            else:
                print(x.name[i],end=' ')
        print('')
        

create_spend_chart([Food,Chilre])