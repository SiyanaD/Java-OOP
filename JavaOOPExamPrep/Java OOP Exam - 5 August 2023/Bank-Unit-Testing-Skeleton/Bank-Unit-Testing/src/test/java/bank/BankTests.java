package bank;

import org.junit.Assert;
import org.junit.Test;

public class BankTests {

@Test(expected = IllegalArgumentException.class)

    public void testWithInvalidCapacity(){
    new Bank("B1",-1);//capacity < 0
}
@Test(expected = NullPointerException.class)
    public void testNameInvalid(){
    new Bank(null,1);
}
@Test(expected = NullPointerException.class)
    public void testNameWhichIsEmpty(){
    new Bank(" ",1);
}

//valid test
    @Test
    public void testCreateBank(){
    Bank bank = new Bank("Bank",5);
        Assert.assertEquals("Bank",bank.getName());
        Assert.assertEquals(5,bank.getCapacity());
    }

    //addClient
    @Test
    public void testAddClient(){
    Bank bank = new Bank("Bank",5);
    Client client = new Client("Client");
    Assert.assertEquals(0,bank.getCount());
    bank.addClient(client);
    Assert.assertEquals(1,bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddClientThrowFilledBank(){
        Bank bank = new Bank("Bank",1);
        Client client = new Client("Client");
        bank.addClient(client);

        Client client2 = new Client("Client");
        bank.addClient(client2);

    }

    //removeClient
    @Test
    public void testRemoveClient(){
        Bank bank = new Bank("Bank",3);
        Client client1 = new Client("Client1");
        Client client2 = new Client("Client2");
        bank.addClient(client1);
        bank.addClient(client2);
        Assert.assertEquals(2,bank.getCount());
        bank.removeClient("Client1");
        Assert.assertEquals(1,bank.getCount());
        bank.removeClient("Client2");
        Assert.assertEquals(0,bank.getCount());

    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingClient(){
        Bank bank = new Bank("Bank",3);
        bank.removeClient("Client1");


    }

    //loanWithdrawal
    @Test
    public void testLoanWithdrawal(){
        Bank bank = new Bank("Bank",1);
        Client client = new Client("Client");
        bank.addClient(client);
        Client returnClient = bank.loanWithdrawal("Client");
        Assert.assertFalse(returnClient.isApprovedForLoan());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testLoanWithdrawalNonExisting(){
        Bank bank = new Bank("Bank",1);
        bank.loanWithdrawal("Client");
    }

    //statistics
    @Test
    public void testStatistics(){
        Bank bank = new Bank("Bank",1);
        Client client = new Client("Client");
        bank.addClient(client);

        Assert.assertEquals("The client Client is at the Bank bank!"
                ,bank.statistics());
    }
}

