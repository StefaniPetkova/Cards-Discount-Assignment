package com.company;
import static com.company.PayDesk.information;

class Main {

    public static void main(String[] args) {

        Bronze br=new Bronze(150,0);
        System.out.println(br);
        Silver sl=new Silver(850,600);
        sl.calculateDiscountRate();
        sl.calculateDiscount(850);
        System.out.println(sl);
        Gold gd=new Gold(1300,1500);
        gd.calculateDiscountRate();
        gd.calculateDiscount(1300);
        System.out.println(gd);


        information(gd);

    }
}

abstract class DiscountCards
{
    String name;
    private int turnover;
    private double discountRate;
    private double purchaseValue;
    private double currDicsount;


    public double calculateTotal()
    {
        return getPurchaseValue()-getCurrDicsount();
    }


    public int getTurnover()
    {
        return turnover;
    }

    public void setTurnover(int turnover)
    {
        if(turnover<0)
            turnover=0;
        this.turnover = turnover;

    }

    public double getDiscountRate()
    {
        return discountRate;
    }

    public void setDiscountRate(double discountRate)
    {
        if(discountRate<0)
            discountRate=0;
        this.discountRate = discountRate;
    }

    public double getPurchaseValue()
    {
        return purchaseValue;
    }

    public void setPurchaseValue(double purchaseValue)
    {
        if(purchaseValue<0)
            purchaseValue=0;
        this.purchaseValue = purchaseValue;
    }

    public double getCurrDicsount()
    {
        return currDicsount;
    }


    DiscountCards(double purchaseValue, int turnover)
    {
        setPurchaseValue(purchaseValue);
        setTurnover(turnover);

    }

    public  double calculateDiscount(double purchaseValue)
    {
        currDicsount=(purchaseValue*discountRate)/100;
        return currDicsount;
    }
    public abstract void calculateDiscountRate();

    @Override
    public String toString()
    {
        return getPurchaseValue()+"  "+getDiscountRate()+"  "+getCurrDicsount()+"  "+calculateTotal();
    }
}


class Bronze extends DiscountCards
{
    Bronze(double purchaseValue, int turnover)
    {
        super(purchaseValue,turnover);
    }

    @Override
    public void calculateDiscountRate()
    {
        if(getTurnover()<100)
            setDiscountRate(0);
        else if(getTurnover()>100 && getTurnover()<300)
            setDiscountRate(1);
        else
            setDiscountRate(2.5);
    }
}

class Silver extends DiscountCards
{
    Silver(double purchaseValue, int turnover)
    {
        super(purchaseValue,turnover);
    }

    @Override
    public void calculateDiscountRate()
    {
        if(getTurnover()>300)
            setDiscountRate(3.5);
        else
            setDiscountRate(2);

    }
}

class Gold extends DiscountCards
{
    Gold(double purchaseValue, int turnover)
    {
        super(purchaseValue,turnover);
    }

    @Override
    public void calculateDiscountRate()
    {
        double del=getTurnover()/100;
        if(del>=1 && del<=10)
            setDiscountRate(del+2);
        else if(del>10)
            setDiscountRate(10);
        else
            setDiscountRate(2);
    }
}
class PayDesk
{
    public static void information(DiscountCards ob)
    {
        System.out.println(ob.getDiscountRate()+"  "+ob.getCurrDicsount()+"  "+ob.calculateTotal());
    }
}