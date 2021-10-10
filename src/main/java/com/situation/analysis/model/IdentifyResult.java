package com.situation.analysis.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description:
 * @author: Kobe
 * @date: 2021/10/9 下午3:19
 * @version: v1.0
 */
@NoArgsConstructor
@Data
public class IdentifyResult {
    @JsonProperty("type")
    private String type;
    @JsonProperty("orientation")
    private Integer orientation;
    @JsonProperty("region")
    private List<Integer> region;
    @JsonProperty("details")
    private DetailsDTO details;
    @JsonProperty("extra")
    private ExtraDTO extra;

    @NoArgsConstructor
    @Data
    public static class DetailsDTO {
        @JsonProperty("code")
        private String code;
        @JsonProperty("number")
        private String number;
        @JsonProperty("date")
        private String date;
        @JsonProperty("pretax_amount")
        private String pretaxAmount;
        @JsonProperty("tax")
        private String tax;
        @JsonProperty("check_code")
        private String checkCode;
        @JsonProperty("total")
        private String total;
        @JsonProperty("seller")
        private String seller;
        @JsonProperty("seller_tax_id")
        private String sellerTaxId;
        @JsonProperty("buyer")
        private String buyer;
        @JsonProperty("buyer_tax_id")
        private String buyerTaxId;
        @JsonProperty("company_seal")
        private String companySeal;
        @JsonProperty("form_type")
        private String formType;
        @JsonProperty("kind")
        private String kind;
        @JsonProperty("ciphertext")
        private String ciphertext;
        @JsonProperty("machine_code")
        private String machineCode;
        @JsonProperty("receiptor")
        private String receiptor;
        @JsonProperty("reviewer")
        private String reviewer;
        @JsonProperty("issuer")
        private String issuer;
        @JsonProperty("province")
        private String province;
        @JsonProperty("city")
        private String city;
        @JsonProperty("service_name")
        private String serviceName;
        @JsonProperty("remark")
        private String remark;
        @JsonProperty("item_names")
        private String itemNames;
        @JsonProperty("seller_addr_tel")
        private String sellerAddrTel;
        @JsonProperty("seller_bank_account")
        private String sellerBankAccount;
        @JsonProperty("items")
        private List<ItemsDTO> items;
        @JsonProperty("producer_stamp")
        private String producerStamp;
        @JsonProperty("title")
        private String title;
        @JsonProperty("stamp_info")
        private String stampInfo;
        @JsonProperty("code_confirm")
        private String codeConfirm;
        @JsonProperty("electronic_mark")
        private String electronicMark;

        @NoArgsConstructor
        @Data
        public static class ItemsDTO {
            @JsonProperty("name")
            private String name;
            @JsonProperty("total")
            private String total;
            @JsonProperty("tax_rate")
            private String taxRate;
            @JsonProperty("tax")
            private String tax;
        }
    }

    @NoArgsConstructor
    @Data
    public static class ExtraDTO {
        @JsonProperty("check_code_candidates")
        private List<?> checkCodeCandidates;
        @JsonProperty("check_code_last_six")
        private List<?> checkCodeLastSix;
        @JsonProperty("number_order_error")
        private List<?> numberOrderError;
        @JsonProperty("qrcode")
        private List<String> qrcode;
    }
}
