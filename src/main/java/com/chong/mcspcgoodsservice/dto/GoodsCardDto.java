package com.chong.mcspcgoodsservice.dto;

import com.chong.mcspcgoodsservice.entity.McGoods;
import com.chong.mcspcgoodsservice.entity.McGoodsSku;
import com.chong.mcspcgoodsservice.entity.McGoodsSkuCard;

public class GoodsCardDto {
    private McGoods mcGoods;
    private McGoodsSku mcGoodsSku;
    private McGoodsSkuCard mcGoodsSkuCard;

    public GoodsCardDto(){
        this.mcGoods = new McGoods();
        this.mcGoodsSku = new McGoodsSku();
        this.mcGoodsSkuCard = new McGoodsSkuCard();
    }

    public McGoods getMcGoods() {
        return mcGoods;
    }

    public void setMcGoods(McGoods mcGoods) {
        this.mcGoods = mcGoods;
    }

    public McGoodsSku getMcGoodsSku() {
        return mcGoodsSku;
    }

    public void setMcGoodsSku(McGoodsSku mcGoodsSku) {
        this.mcGoodsSku = mcGoodsSku;
    }

    public McGoodsSkuCard getMcGoodsSkuCard() {
        return mcGoodsSkuCard;
    }

    public void setMcGoodsSkuCard(McGoodsSkuCard mcGoodsSkuCard) {
        this.mcGoodsSkuCard = mcGoodsSkuCard;
    }
}
