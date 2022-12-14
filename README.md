# BYT_PROJECT_RING_SELL
This is a project about buying a ring, also ordering through a jeweler who will make orders.
# Person class
    In this class has attributes:  
        - firstName;
        - lastName;
        - phoneNumber;
        - address;

# Customer class
    In this class has extended of Person class.

# Jeweler class
    In this class has extended of Person class. And also has attribute: 
        - priceService;

# MaterialType class
    This class about materials that jewelry is made of, alsp has attributes: 
        - priceService;

# Transaction class
    This class about information transaction for order, also has attributes:
        - dateTransaction;
        - sum; This attribute about total summa that should pay customer (weight * priceForGramm + priceService)
# StatusType class
    This class is enum, that has status': 
        - PAID, NOT_PAID,PARTLY_PAID, IN_PROGRESS, FINISHED  
# Order class 
    This class in important class, also has attributes & methods:
        - ringSize;
        - weight;
        - orderDate;
        - needToPay;
        - createOrder() method created just order by Custosmer;
        - takenOrder() method, Jeweler taked one order, that will do;
        - getStatusOfOrder() method for check and get current status order;
        - calculatedTotalSum() method for to calculate total summa;
        - startDoOrder() method for change status to IN_PROGRESS;
        - finishedOrder() method for change status to FINISHED;
        - doTransaction(Double money) method for customer should pay for order;
        - getNextOrder() method for get order of orderList and remove element;