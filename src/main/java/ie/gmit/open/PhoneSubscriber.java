package ie.gmit.open;

import java.util.List;

public class PhoneSubscriber extends Subscriber{


    private int baseRate;

    public PhoneSubscriber(Long subscriberId, String address, Long phoneNumber, int baseRate) {
        super(subscriberId, address, phoneNumber);
        this.baseRate = baseRate;
    }

    public double calculateBill() {
        List<CallHistory.Call> sessions = CallHistory.getCurrentCalls(getSubscriberId());
        long totalDuration = sessions.stream().mapToLong(CallHistory.Call::getDuration).sum();
        return totalDuration*baseRate/100;
    }


    /**
     * @return the baseRate
     */
    public int getBaseRate() {
        return baseRate;
    }

    /**
     * @param baseRate the baseRate to set
     */
    public void setBaseRate(int baseRate) {
        this.baseRate = baseRate;
    }

}