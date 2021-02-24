package net.hari.enums;

/**
 * @Auther: Hari
 * @Date: 2021/2/24 10:22
 * @Description:
 */
/**
 * 收货地址状态
 */
public enum AddressStatusEnum {


    /**
     * 是默认收货地址
     */
    DEFAULT_STATUS(1),

    /**
     * 非默认收货地址
     */
    COMMON_STATUS(0);

    private int status;

    private AddressStatusEnum(int status){
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
