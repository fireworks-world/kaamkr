package com.blakoo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CouponUtils {
    /**
     * Sample JSON response for a Admitad query
     */
    private static final String SAMPLE_JSON_RESPONSE = "{\n" +
            "   \"_meta\":{\n" +
            "      \"count\":998,\n" +
            "      \"limit\":7,\n" +
            "      \"offset\":0\n" +
            "   },\n" +
            "   \"results\":[\n" +
            "      {\n" +
            "         \"status\":\"active\",\n" +
            "         \"rating\":\"9.99\",\n" +
            "         \"campaign\":{\n" +
            "            \"id\":13623,\n" +
            "            \"name\":\"Banggood WW\",\n" +
            "            \"site_url\":\"https://www.banggood.com/\"\n" +
            "         },\n" +
            "         \"description\":\"Excludes categories:Power Banks,SmartPhone,Feature Phones,TV Boxes,Electric Bikes,Electric Scooters & Wheels,Laptops & Netbooks,Projectors & Accessories,Home Appliances,Practical Electronic Gadgets,FPV System,Radios & Receiver,Watch Phone,Indoor Lighting,3D Printer,Television & Accessories,Mini PC,Graphics Card,Android Tablet,Windows Tablet,Monitor,Office Furniture,Measurement & Analysis Instruments,TV Receiver & Accessories,Smart Watch\",\n" +
            "         \"short_name\":\"Banggood 10% OFF Site Wide Coupon\",\n" +
            "         \"exclusive\":false,\n" +
            "         \"date_end\":null,\n" +
            "         \"date_start\":\"2020-04-01T00:00:00\",\n" +
            "         \"id\":305905,\n" +
            "         \"regions\":[\n" +
            "            \"AD\",\n" +
            "            \"AE\",\n" +
            "            \"AF\",\n" +
            "            \"AG\",\n" +
            "            \"AI\",\n" +
            "            \"AL\",\n" +
            "            \"AM\",\n" +
            "            \"AO\",\n" +
            "            \"AQ\",\n" +
            "            \"AR\",\n" +
            "            \"AS\",\n" +
            "            \"AT\",\n" +
            "            \"AU\",\n" +
            "            \"AW\",\n" +
            "            \"AX\",\n" +
            "            \"AZ\",\n" +
            "            \"BA\",\n" +
            "            \"BB\",\n" +
            "            \"BD\",\n" +
            "            \"BE\",\n" +
            "            \"BF\",\n" +
            "            \"BG\",\n" +
            "            \"BH\",\n" +
            "            \"BI\",\n" +
            "            \"BJ\",\n" +
            "            \"BL\",\n" +
            "            \"BM\",\n" +
            "            \"BN\",\n" +
            "            \"BO\",\n" +
            "            \"BQ\",\n" +
            "            \"BR\",\n" +
            "            \"BS\",\n" +
            "            \"BT\",\n" +
            "            \"BV\",\n" +
            "            \"BW\",\n" +
            "            \"BY\",\n" +
            "            \"BZ\",\n" +
            "            \"CA\",\n" +
            "            \"CC\",\n" +
            "            \"CD\",\n" +
            "            \"CF\",\n" +
            "            \"CG\",\n" +
            "            \"CH\",\n" +
            "            \"CI\",\n" +
            "            \"CK\",\n" +
            "            \"CL\",\n" +
            "            \"CM\",\n" +
            "            \"CO\",\n" +
            "            \"CR\",\n" +
            "            \"CU\",\n" +
            "            \"CV\",\n" +
            "            \"CW\",\n" +
            "            \"CX\",\n" +
            "            \"CY\",\n" +
            "            \"CZ\",\n" +
            "            \"DE\",\n" +
            "            \"DJ\",\n" +
            "            \"DK\",\n" +
            "            \"DM\",\n" +
            "            \"DO\",\n" +
            "            \"DZ\",\n" +
            "            \"EC\",\n" +
            "            \"EE\",\n" +
            "            \"EG\",\n" +
            "            \"EH\",\n" +
            "            \"ER\",\n" +
            "            \"ES\",\n" +
            "            \"ET\",\n" +
            "            \"FI\",\n" +
            "            \"FJ\",\n" +
            "            \"FK\",\n" +
            "            \"FM\",\n" +
            "            \"FO\",\n" +
            "            \"FR\",\n" +
            "            \"GA\",\n" +
            "            \"GB\",\n" +
            "            \"GD\",\n" +
            "            \"GE\",\n" +
            "            \"GF\",\n" +
            "            \"GG\",\n" +
            "            \"GH\",\n" +
            "            \"GI\",\n" +
            "            \"GL\",\n" +
            "            \"GM\",\n" +
            "            \"GN\",\n" +
            "            \"GP\",\n" +
            "            \"GQ\",\n" +
            "            \"GR\",\n" +
            "            \"GS\",\n" +
            "            \"GT\",\n" +
            "            \"GU\",\n" +
            "            \"GW\",\n" +
            "            \"GY\",\n" +
            "            \"HK\",\n" +
            "            \"HM\",\n" +
            "            \"HN\",\n" +
            "            \"HR\",\n" +
            "            \"HT\",\n" +
            "            \"HU\",\n" +
            "            \"ID\",\n" +
            "            \"IE\",\n" +
            "            \"IL\",\n" +
            "            \"IM\",\n" +
            "            \"IN\",\n" +
            "            \"IO\",\n" +
            "            \"IQ\",\n" +
            "            \"IR\",\n" +
            "            \"IS\",\n" +
            "            \"IT\",\n" +
            "            \"JE\",\n" +
            "            \"JM\",\n" +
            "            \"JO\",\n" +
            "            \"JP\",\n" +
            "            \"KE\",\n" +
            "            \"KG\",\n" +
            "            \"KH\",\n" +
            "            \"KI\",\n" +
            "            \"KM\",\n" +
            "            \"KN\",\n" +
            "            \"KP\",\n" +
            "            \"KR\",\n" +
            "            \"KW\",\n" +
            "            \"KY\",\n" +
            "            \"KZ\",\n" +
            "            \"LA\",\n" +
            "            \"LB\",\n" +
            "            \"LC\",\n" +
            "            \"LI\",\n" +
            "            \"LK\",\n" +
            "            \"LR\",\n" +
            "            \"LS\",\n" +
            "            \"LT\",\n" +
            "            \"LU\",\n" +
            "            \"LV\",\n" +
            "            \"LY\",\n" +
            "            \"MA\",\n" +
            "            \"MC\",\n" +
            "            \"MD\",\n" +
            "            \"ME\",\n" +
            "            \"MF\",\n" +
            "            \"MG\",\n" +
            "            \"MH\",\n" +
            "            \"MK\",\n" +
            "            \"ML\",\n" +
            "            \"MM\",\n" +
            "            \"MN\",\n" +
            "            \"MO\",\n" +
            "            \"MP\",\n" +
            "            \"MQ\",\n" +
            "            \"MR\",\n" +
            "            \"MS\",\n" +
            "            \"MT\",\n" +
            "            \"MU\",\n" +
            "            \"MV\",\n" +
            "            \"MW\",\n" +
            "            \"MX\",\n" +
            "            \"MY\",\n" +
            "            \"MZ\",\n" +
            "            \"NA\",\n" +
            "            \"NC\",\n" +
            "            \"NE\",\n" +
            "            \"NF\",\n" +
            "            \"NG\",\n" +
            "            \"NI\",\n" +
            "            \"NL\",\n" +
            "            \"NO\",\n" +
            "            \"NP\",\n" +
            "            \"NR\",\n" +
            "            \"NU\",\n" +
            "            \"NZ\",\n" +
            "            \"OM\",\n" +
            "            \"PA\",\n" +
            "            \"PE\",\n" +
            "            \"PF\",\n" +
            "            \"PG\",\n" +
            "            \"PH\",\n" +
            "            \"PK\",\n" +
            "            \"PL\",\n" +
            "            \"PM\",\n" +
            "            \"PN\",\n" +
            "            \"PR\",\n" +
            "            \"PS\",\n" +
            "            \"PT\",\n" +
            "            \"PW\",\n" +
            "            \"PY\",\n" +
            "            \"QA\",\n" +
            "            \"RE\",\n" +
            "            \"RO\",\n" +
            "            \"RS\",\n" +
            "            \"RU\",\n" +
            "            \"RW\",\n" +
            "            \"SA\",\n" +
            "            \"SB\",\n" +
            "            \"SC\",\n" +
            "            \"SD\",\n" +
            "            \"SE\",\n" +
            "            \"SG\",\n" +
            "            \"SH\",\n" +
            "            \"SI\",\n" +
            "            \"SJ\",\n" +
            "            \"SK\",\n" +
            "            \"SL\",\n" +
            "            \"SM\",\n" +
            "            \"SN\",\n" +
            "            \"SO\",\n" +
            "            \"SR\",\n" +
            "            \"SS\",\n" +
            "            \"ST\",\n" +
            "            \"SV\",\n" +
            "            \"SX\",\n" +
            "            \"SY\",\n" +
            "            \"SZ\",\n" +
            "            \"TC\",\n" +
            "            \"TD\",\n" +
            "            \"TF\",\n" +
            "            \"TG\",\n" +
            "            \"TH\",\n" +
            "            \"TJ\",\n" +
            "            \"TK\",\n" +
            "            \"TL\",\n" +
            "            \"TM\",\n" +
            "            \"TN\",\n" +
            "            \"TO\",\n" +
            "            \"TR\",\n" +
            "            \"TT\",\n" +
            "            \"TV\",\n" +
            "            \"TW\",\n" +
            "            \"TZ\",\n" +
            "            \"UA\",\n" +
            "            \"UG\",\n" +
            "            \"UM\",\n" +
            "            \"US\",\n" +
            "            \"UY\",\n" +
            "            \"UZ\",\n" +
            "            \"VA\",\n" +
            "            \"VC\",\n" +
            "            \"VE\",\n" +
            "            \"VG\",\n" +
            "            \"VI\",\n" +
            "            \"VN\",\n" +
            "            \"VU\",\n" +
            "            \"WF\",\n" +
            "            \"WS\",\n" +
            "            \"YE\",\n" +
            "            \"YT\",\n" +
            "            \"ZA\",\n" +
            "            \"ZM\",\n" +
            "            \"ZW\"\n" +
            "         ],\n" +
            "         \"discount\":\"10%\",\n" +
            "         \"types\":[\n" +
            "            {\n" +
            "               \"id\":2,\n" +
            "               \"name\":\"Скидка на заказ\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"image\":\"http://cdn.admitad.com/campaign/images/2015/03/13/26eb60d1e6b5d4ec7c92062e5d1e8430.jpg\",\n" +
            "         \"species\":\"promocode\",\n" +
            "         \"categories\":[\n" +
            "            {\n" +
            "               \"id\":8,\n" +
            "               \"name\":\"Компьютеры и электроника\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"name\":\"Banggood 10% OFF Site Wide Coupon\",\n" +
            "         \"promocode\":\"BGAFF10OFF\",\n" +
            "         \"frameset_link\":\"\",\n" +
            "         \"goto_link\":\"https://ad.admitad.com/g/tx4zgk4gbq2e4b3978f86213826a88/?i=3\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"status\":\"active\",\n" +
            "         \"rating\":\"9.81\",\n" +
            "         \"campaign\":{\n" +
            "            \"id\":6115,\n" +
            "            \"name\":\"AliExpress WW\",\n" +
            "            \"site_url\":\"http://aliexpress.com/\"\n" +
            "         },\n" +
            "         \"description\":\"Valid for all buyers\",\n" +
            "         \"short_name\":\"$10 discount on order over $40 in LadyModa Store\",\n" +
            "         \"exclusive\":false,\n" +
            "         \"date_end\":null,\n" +
            "         \"date_start\":\"2020-02-10T00:00:00\",\n" +
            "         \"id\":296476,\n" +
            "         \"regions\":[\n" +
            "            \"AD\",\n" +
            "            \"AE\",\n" +
            "            \"AF\",\n" +
            "            \"AG\",\n" +
            "            \"AI\",\n" +
            "            \"AL\",\n" +
            "            \"AM\",\n" +
            "            \"AO\",\n" +
            "            \"AQ\",\n" +
            "            \"AR\",\n" +
            "            \"AS\",\n" +
            "            \"AT\",\n" +
            "            \"AU\",\n" +
            "            \"AW\",\n" +
            "            \"AX\",\n" +
            "            \"AZ\",\n" +
            "            \"BA\",\n" +
            "            \"BB\",\n" +
            "            \"BD\",\n" +
            "            \"BE\",\n" +
            "            \"BF\",\n" +
            "            \"BG\",\n" +
            "            \"BH\",\n" +
            "            \"BI\",\n" +
            "            \"BJ\",\n" +
            "            \"BM\",\n" +
            "            \"BN\",\n" +
            "            \"BO\",\n" +
            "            \"BR\",\n" +
            "            \"BS\",\n" +
            "            \"BT\",\n" +
            "            \"BV\",\n" +
            "            \"BW\",\n" +
            "            \"BZ\",\n" +
            "            \"CA\",\n" +
            "            \"CC\",\n" +
            "            \"CD\",\n" +
            "            \"CF\",\n" +
            "            \"CG\",\n" +
            "            \"CH\",\n" +
            "            \"CI\",\n" +
            "            \"CK\",\n" +
            "            \"CL\",\n" +
            "            \"CM\",\n" +
            "            \"CN\",\n" +
            "            \"CO\",\n" +
            "            \"CR\",\n" +
            "            \"CU\",\n" +
            "            \"CV\",\n" +
            "            \"CW\",\n" +
            "            \"CX\",\n" +
            "            \"CY\",\n" +
            "            \"CZ\",\n" +
            "            \"DE\",\n" +
            "            \"DJ\",\n" +
            "            \"DK\",\n" +
            "            \"DM\",\n" +
            "            \"DO\",\n" +
            "            \"DZ\",\n" +
            "            \"EC\",\n" +
            "            \"EE\",\n" +
            "            \"EG\",\n" +
            "            \"EH\",\n" +
            "            \"ER\",\n" +
            "            \"ES\",\n" +
            "            \"ET\",\n" +
            "            \"FI\",\n" +
            "            \"FJ\",\n" +
            "            \"FK\",\n" +
            "            \"FM\",\n" +
            "            \"FO\",\n" +
            "            \"FR\",\n" +
            "            \"GA\",\n" +
            "            \"GB\",\n" +
            "            \"GD\",\n" +
            "            \"GE\",\n" +
            "            \"GF\",\n" +
            "            \"GG\",\n" +
            "            \"GH\",\n" +
            "            \"GI\",\n" +
            "            \"GL\",\n" +
            "            \"GM\",\n" +
            "            \"GN\",\n" +
            "            \"GP\",\n" +
            "            \"GQ\",\n" +
            "            \"GR\",\n" +
            "            \"GS\",\n" +
            "            \"GT\",\n" +
            "            \"GU\",\n" +
            "            \"GW\",\n" +
            "            \"GY\",\n" +
            "            \"HK\",\n" +
            "            \"HM\",\n" +
            "            \"HN\",\n" +
            "            \"HR\",\n" +
            "            \"HT\",\n" +
            "            \"HU\",\n" +
            "            \"ID\",\n" +
            "            \"IE\",\n" +
            "            \"IL\",\n" +
            "            \"IM\",\n" +
            "            \"IO\",\n" +
            "            \"IQ\",\n" +
            "            \"IR\",\n" +
            "            \"IS\",\n" +
            "            \"IT\",\n" +
            "            \"JE\",\n" +
            "            \"JM\",\n" +
            "            \"JO\",\n" +
            "            \"JP\",\n" +
            "            \"KE\",\n" +
            "            \"KG\",\n" +
            "            \"KH\",\n" +
            "            \"KI\",\n" +
            "            \"KM\",\n" +
            "            \"KN\",\n" +
            "            \"KP\",\n" +
            "            \"KR\",\n" +
            "            \"KW\",\n" +
            "            \"KY\",\n" +
            "            \"LA\",\n" +
            "            \"LB\",\n" +
            "            \"LC\",\n" +
            "            \"LI\",\n" +
            "            \"LK\",\n" +
            "            \"LR\",\n" +
            "            \"LS\",\n" +
            "            \"LT\",\n" +
            "            \"LU\",\n" +
            "            \"LV\",\n" +
            "            \"LY\",\n" +
            "            \"MA\",\n" +
            "            \"MC\",\n" +
            "            \"MD\",\n" +
            "            \"ME\",\n" +
            "            \"MG\",\n" +
            "            \"MH\",\n" +
            "            \"MK\",\n" +
            "            \"ML\",\n" +
            "            \"MM\",\n" +
            "            \"MN\",\n" +
            "            \"MO\",\n" +
            "            \"MP\",\n" +
            "            \"MQ\",\n" +
            "            \"MR\",\n" +
            "            \"MS\",\n" +
            "            \"MT\",\n" +
            "            \"MU\",\n" +
            "            \"MV\",\n" +
            "            \"MW\",\n" +
            "            \"MX\",\n" +
            "            \"MY\",\n" +
            "            \"MZ\",\n" +
            "            \"NA\",\n" +
            "            \"NC\",\n" +
            "            \"NE\",\n" +
            "            \"NF\",\n" +
            "            \"NG\",\n" +
            "            \"NI\",\n" +
            "            \"NL\",\n" +
            "            \"NO\",\n" +
            "            \"NP\",\n" +
            "            \"NR\",\n" +
            "            \"NU\",\n" +
            "            \"NZ\",\n" +
            "            \"OM\",\n" +
            "            \"PA\",\n" +
            "            \"PE\",\n" +
            "            \"PF\",\n" +
            "            \"PG\",\n" +
            "            \"PH\",\n" +
            "            \"PK\",\n" +
            "            \"PL\",\n" +
            "            \"PM\",\n" +
            "            \"PN\",\n" +
            "            \"PR\",\n" +
            "            \"PS\",\n" +
            "            \"PT\",\n" +
            "            \"PW\",\n" +
            "            \"PY\",\n" +
            "            \"QA\",\n" +
            "            \"RE\",\n" +
            "            \"RO\",\n" +
            "            \"RS\",\n" +
            "            \"RW\",\n" +
            "            \"SA\",\n" +
            "            \"SB\",\n" +
            "            \"SC\",\n" +
            "            \"SD\",\n" +
            "            \"SE\",\n" +
            "            \"SG\",\n" +
            "            \"SH\",\n" +
            "            \"SI\",\n" +
            "            \"SJ\",\n" +
            "            \"SK\",\n" +
            "            \"SL\",\n" +
            "            \"SM\",\n" +
            "            \"SN\",\n" +
            "            \"SO\",\n" +
            "            \"SR\",\n" +
            "            \"ST\",\n" +
            "            \"SV\",\n" +
            "            \"SY\",\n" +
            "            \"SZ\",\n" +
            "            \"TC\",\n" +
            "            \"TD\",\n" +
            "            \"TF\",\n" +
            "            \"TG\",\n" +
            "            \"TH\",\n" +
            "            \"TJ\",\n" +
            "            \"TK\",\n" +
            "            \"TL\",\n" +
            "            \"TM\",\n" +
            "            \"TN\",\n" +
            "            \"TO\",\n" +
            "            \"TT\",\n" +
            "            \"TV\",\n" +
            "            \"TW\",\n" +
            "            \"TZ\",\n" +
            "            \"UG\",\n" +
            "            \"UM\",\n" +
            "            \"US\",\n" +
            "            \"UY\",\n" +
            "            \"UZ\",\n" +
            "            \"VA\",\n" +
            "            \"VC\",\n" +
            "            \"VE\",\n" +
            "            \"VG\",\n" +
            "            \"VI\",\n" +
            "            \"VN\",\n" +
            "            \"VU\",\n" +
            "            \"WF\",\n" +
            "            \"WS\",\n" +
            "            \"YE\",\n" +
            "            \"YT\",\n" +
            "            \"ZA\",\n" +
            "            \"ZM\",\n" +
            "            \"ZW\"\n" +
            "         ],\n" +
            "         \"discount\":\"10 $\",\n" +
            "         \"types\":[\n" +
            "            {\n" +
            "               \"id\":2,\n" +
            "               \"name\":\"Скидка на заказ\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"image\":\"http://cdn.admitad.com/campaign/images/2015/05/12/a81cc17e95c570a41c661fb1aa6c6439.jpg\",\n" +
            "         \"species\":\"promocode\",\n" +
            "         \"categories\":[\n" +
            "            {\n" +
            "               \"id\":7,\n" +
            "               \"name\":\"Товары для дома\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"name\":\"$10 discount on order over $40 in LadyModa Store\",\n" +
            "         \"promocode\":\"L6CK2PMU5LR1\",\n" +
            "         \"frameset_link\":\"http://alitems.com/coupon/pa6stzjtvd2e4b3978f816525dc3e8/\",\n" +
            "         \"goto_link\":\"https://alitems.com/g/anrffvc2pj2e4b3978f816525dc3e8/?i=3\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"status\":\"active\",\n" +
            "         \"rating\":\"9.05\",\n" +
            "         \"campaign\":{\n" +
            "            \"id\":6115,\n" +
            "            \"name\":\"AliExpress WW\",\n" +
            "            \"site_url\":\"http://aliexpress.com/\"\n" +
            "         },\n" +
            "         \"description\":\"\",\n" +
            "         \"short_name\":\"MARCAS TOPS | Até 70% OFF nos FAVORITOS e MAIS VENDIDOS\",\n" +
            "         \"exclusive\":false,\n" +
            "         \"date_end\":\"2020-12-31T23:59:00\",\n" +
            "         \"date_start\":\"2020-07-29T18:22:00\",\n" +
            "         \"id\":322179,\n" +
            "         \"regions\":[\n" +
            "            \"AD\",\n" +
            "            \"AE\",\n" +
            "            \"AF\",\n" +
            "            \"AG\",\n" +
            "            \"AI\",\n" +
            "            \"AL\",\n" +
            "            \"AM\",\n" +
            "            \"AO\",\n" +
            "            \"AQ\",\n" +
            "            \"AR\",\n" +
            "            \"AS\",\n" +
            "            \"AT\",\n" +
            "            \"AU\",\n" +
            "            \"AW\",\n" +
            "            \"AX\",\n" +
            "            \"AZ\",\n" +
            "            \"BA\",\n" +
            "            \"BB\",\n" +
            "            \"BD\",\n" +
            "            \"BE\",\n" +
            "            \"BF\",\n" +
            "            \"BG\",\n" +
            "            \"BH\",\n" +
            "            \"BI\",\n" +
            "            \"BJ\",\n" +
            "            \"BM\",\n" +
            "            \"BN\",\n" +
            "            \"BO\",\n" +
            "            \"BR\",\n" +
            "            \"BS\",\n" +
            "            \"BT\",\n" +
            "            \"BV\",\n" +
            "            \"BW\",\n" +
            "            \"BZ\",\n" +
            "            \"CA\",\n" +
            "            \"CC\",\n" +
            "            \"CD\",\n" +
            "            \"CF\",\n" +
            "            \"CG\",\n" +
            "            \"CH\",\n" +
            "            \"CI\",\n" +
            "            \"CK\",\n" +
            "            \"CL\",\n" +
            "            \"CM\",\n" +
            "            \"CN\",\n" +
            "            \"CO\",\n" +
            "            \"CR\",\n" +
            "            \"CU\",\n" +
            "            \"CV\",\n" +
            "            \"CW\",\n" +
            "            \"CX\",\n" +
            "            \"CY\",\n" +
            "            \"CZ\",\n" +
            "            \"DE\",\n" +
            "            \"DJ\",\n" +
            "            \"DK\",\n" +
            "            \"DM\",\n" +
            "            \"DO\",\n" +
            "            \"DZ\",\n" +
            "            \"EC\",\n" +
            "            \"EE\",\n" +
            "            \"EG\",\n" +
            "            \"EH\",\n" +
            "            \"ER\",\n" +
            "            \"ES\",\n" +
            "            \"ET\",\n" +
            "            \"FI\",\n" +
            "            \"FJ\",\n" +
            "            \"FK\",\n" +
            "            \"FM\",\n" +
            "            \"FO\",\n" +
            "            \"FR\",\n" +
            "            \"GA\",\n" +
            "            \"GB\",\n" +
            "            \"GD\",\n" +
            "            \"GE\",\n" +
            "            \"GF\",\n" +
            "            \"GG\",\n" +
            "            \"GH\",\n" +
            "            \"GI\",\n" +
            "            \"GL\",\n" +
            "            \"GM\",\n" +
            "            \"GN\",\n" +
            "            \"GP\",\n" +
            "            \"GQ\",\n" +
            "            \"GR\",\n" +
            "            \"GS\",\n" +
            "            \"GT\",\n" +
            "            \"GU\",\n" +
            "            \"GW\",\n" +
            "            \"GY\",\n" +
            "            \"HK\",\n" +
            "            \"HM\",\n" +
            "            \"HN\",\n" +
            "            \"HR\",\n" +
            "            \"HT\",\n" +
            "            \"HU\",\n" +
            "            \"ID\",\n" +
            "            \"IE\",\n" +
            "            \"IL\",\n" +
            "            \"IM\",\n" +
            "            \"IO\",\n" +
            "            \"IQ\",\n" +
            "            \"IR\",\n" +
            "            \"IS\",\n" +
            "            \"IT\",\n" +
            "            \"JE\",\n" +
            "            \"JM\",\n" +
            "            \"JO\",\n" +
            "            \"JP\",\n" +
            "            \"KE\",\n" +
            "            \"KG\",\n" +
            "            \"KH\",\n" +
            "            \"KI\",\n" +
            "            \"KM\",\n" +
            "            \"KN\",\n" +
            "            \"KP\",\n" +
            "            \"KR\",\n" +
            "            \"KW\",\n" +
            "            \"KY\",\n" +
            "            \"LA\",\n" +
            "            \"LB\",\n" +
            "            \"LC\",\n" +
            "            \"LI\",\n" +
            "            \"LK\",\n" +
            "            \"LR\",\n" +
            "            \"LS\",\n" +
            "            \"LT\",\n" +
            "            \"LU\",\n" +
            "            \"LV\",\n" +
            "            \"LY\",\n" +
            "            \"MA\",\n" +
            "            \"MC\",\n" +
            "            \"MD\",\n" +
            "            \"ME\",\n" +
            "            \"MG\",\n" +
            "            \"MH\",\n" +
            "            \"MK\",\n" +
            "            \"ML\",\n" +
            "            \"MM\",\n" +
            "            \"MN\",\n" +
            "            \"MO\",\n" +
            "            \"MP\",\n" +
            "            \"MQ\",\n" +
            "            \"MR\",\n" +
            "            \"MS\",\n" +
            "            \"MT\",\n" +
            "            \"MU\",\n" +
            "            \"MV\",\n" +
            "            \"MW\",\n" +
            "            \"MX\",\n" +
            "            \"MY\",\n" +
            "            \"MZ\",\n" +
            "            \"NA\",\n" +
            "            \"NC\",\n" +
            "            \"NE\",\n" +
            "            \"NF\",\n" +
            "            \"NG\",\n" +
            "            \"NI\",\n" +
            "            \"NL\",\n" +
            "            \"NO\",\n" +
            "            \"NP\",\n" +
            "            \"NR\",\n" +
            "            \"NU\",\n" +
            "            \"NZ\",\n" +
            "            \"OM\",\n" +
            "            \"PA\",\n" +
            "            \"PE\",\n" +
            "            \"PF\",\n" +
            "            \"PG\",\n" +
            "            \"PH\",\n" +
            "            \"PK\",\n" +
            "            \"PL\",\n" +
            "            \"PM\",\n" +
            "            \"PN\",\n" +
            "            \"PR\",\n" +
            "            \"PS\",\n" +
            "            \"PT\",\n" +
            "            \"PW\",\n" +
            "            \"PY\",\n" +
            "            \"QA\",\n" +
            "            \"RE\",\n" +
            "            \"RO\",\n" +
            "            \"RS\",\n" +
            "            \"RW\",\n" +
            "            \"SA\",\n" +
            "            \"SB\",\n" +
            "            \"SC\",\n" +
            "            \"SD\",\n" +
            "            \"SE\",\n" +
            "            \"SG\",\n" +
            "            \"SH\",\n" +
            "            \"SI\",\n" +
            "            \"SJ\",\n" +
            "            \"SK\",\n" +
            "            \"SL\",\n" +
            "            \"SM\",\n" +
            "            \"SN\",\n" +
            "            \"SO\",\n" +
            "            \"SR\",\n" +
            "            \"ST\",\n" +
            "            \"SV\",\n" +
            "            \"SY\",\n" +
            "            \"SZ\",\n" +
            "            \"TC\",\n" +
            "            \"TD\",\n" +
            "            \"TF\",\n" +
            "            \"TG\",\n" +
            "            \"TH\",\n" +
            "            \"TJ\",\n" +
            "            \"TK\",\n" +
            "            \"TL\",\n" +
            "            \"TM\",\n" +
            "            \"TN\",\n" +
            "            \"TO\",\n" +
            "            \"TT\",\n" +
            "            \"TV\",\n" +
            "            \"TW\",\n" +
            "            \"TZ\",\n" +
            "            \"UA\",\n" +
            "            \"UG\",\n" +
            "            \"UM\",\n" +
            "            \"US\",\n" +
            "            \"UY\",\n" +
            "            \"UZ\",\n" +
            "            \"VA\",\n" +
            "            \"VC\",\n" +
            "            \"VE\",\n" +
            "            \"VG\",\n" +
            "            \"VI\",\n" +
            "            \"VN\",\n" +
            "            \"VU\",\n" +
            "            \"WF\",\n" +
            "            \"WS\",\n" +
            "            \"YE\",\n" +
            "            \"YT\",\n" +
            "            \"ZA\",\n" +
            "            \"ZM\",\n" +
            "            \"ZW\"\n" +
            "         ],\n" +
            "         \"discount\":\"70%\",\n" +
            "         \"types\":[\n" +
            "            {\n" +
            "               \"id\":2,\n" +
            "               \"name\":\"Скидка на заказ\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"image\":\"http://cdn.admitad.com/campaign/images/2015/05/12/a81cc17e95c570a41c661fb1aa6c6439.jpg\",\n" +
            "         \"species\":\"action\",\n" +
            "         \"categories\":[\n" +
            "            {\n" +
            "               \"id\":2,\n" +
            "               \"name\":\"Красота и здоровье\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":3,\n" +
            "               \"name\":\"Аксессуары и сумки\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":5,\n" +
            "               \"name\":\"Одежда\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":7,\n" +
            "               \"name\":\"Товары для дома\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":8,\n" +
            "               \"name\":\"Компьютеры и электроника\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":34,\n" +
            "               \"name\":\"Товары из Китая\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"name\":\"MARCAS TOPS | Até 70% OFF nos FAVORITOS e MAIS VENDIDOS\",\n" +
            "         \"promocode\":\"NOT REQUIRED\",\n" +
            "         \"frameset_link\":\"http://alitems.com/coupon/67s3ly2vdb2e4b3978f816525dc3e8/\",\n" +
            "         \"goto_link\":\"https://alitems.com/g/59andeelsh2e4b3978f816525dc3e8/?i=3\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"status\":\"active\",\n" +
            "         \"rating\":\"9.02\",\n" +
            "         \"campaign\":{\n" +
            "            \"id\":14622,\n" +
            "            \"name\":\"DHgate WW\",\n" +
            "            \"site_url\":\"http://dhgate.com/\"\n" +
            "         },\n" +
            "         \"description\":\"\",\n" +
            "         \"short_name\":\"$30 off $300+ Purchase\\r\\n\",\n" +
            "         \"exclusive\":true,\n" +
            "         \"date_end\":\"2020-12-31T23:59:00\",\n" +
            "         \"date_start\":\"2020-02-21T00:00:00\",\n" +
            "         \"id\":299299,\n" +
            "         \"regions\":[\n" +
            "            \"AE\",\n" +
            "            \"AR\",\n" +
            "            \"AU\",\n" +
            "            \"BE\",\n" +
            "            \"BO\",\n" +
            "            \"BR\",\n" +
            "            \"BY\",\n" +
            "            \"CA\",\n" +
            "            \"CH\",\n" +
            "            \"CL\",\n" +
            "            \"CO\",\n" +
            "            \"CW\",\n" +
            "            \"CZ\",\n" +
            "            \"DE\",\n" +
            "            \"DK\",\n" +
            "            \"ES\",\n" +
            "            \"FI\",\n" +
            "            \"FR\",\n" +
            "            \"GB\",\n" +
            "            \"GR\",\n" +
            "            \"HU\",\n" +
            "            \"IE\",\n" +
            "            \"IL\",\n" +
            "            \"IT\",\n" +
            "            \"JP\",\n" +
            "            \"KR\",\n" +
            "            \"KZ\",\n" +
            "            \"LU\",\n" +
            "            \"MT\",\n" +
            "            \"MX\",\n" +
            "            \"NL\",\n" +
            "            \"NO\",\n" +
            "            \"NZ\",\n" +
            "            \"PA\",\n" +
            "            \"PE\",\n" +
            "            \"PF\",\n" +
            "            \"PH\",\n" +
            "            \"PK\",\n" +
            "            \"PL\",\n" +
            "            \"PR\",\n" +
            "            \"PT\",\n" +
            "            \"RO\",\n" +
            "            \"RU\",\n" +
            "            \"SA\",\n" +
            "            \"SE\",\n" +
            "            \"SG\",\n" +
            "            \"SI\",\n" +
            "            \"TR\",\n" +
            "            \"UA\",\n" +
            "            \"US\"\n" +
            "         ],\n" +
            "         \"discount\":\"10%\",\n" +
            "         \"types\":[\n" +
            "            {\n" +
            "               \"id\":2,\n" +
            "               \"name\":\"Скидка на заказ\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"image\":\"http://cdn.admitad.com/campaign/images/2016/01/13/2cf320fa4ad27267779b03a5a85ac024.jpg\",\n" +
            "         \"species\":\"promocode\",\n" +
            "         \"categories\":[\n" +
            "            {\n" +
            "               \"id\":1,\n" +
            "               \"name\":\"Товары для детей\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":2,\n" +
            "               \"name\":\"Красота и здоровье\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":3,\n" +
            "               \"name\":\"Аксессуары и сумки\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":4,\n" +
            "               \"name\":\"Обувь \"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":5,\n" +
            "               \"name\":\"Одежда\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":6,\n" +
            "               \"name\":\"Спорт и отдых\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":7,\n" +
            "               \"name\":\"Товары для дома\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":8,\n" +
            "               \"name\":\"Компьютеры и электроника\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":9,\n" +
            "               \"name\":\"Цветы и подарки\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":10,\n" +
            "               \"name\":\"Часы и украшения\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":11,\n" +
            "               \"name\":\"Еда\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":12,\n" +
            "               \"name\":\"Туры и путешествия\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":14,\n" +
            "               \"name\":\"Книги\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":15,\n" +
            "               \"name\":\"Финансы и страхование\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":17,\n" +
            "               \"name\":\"Зоотовары\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":18,\n" +
            "               \"name\":\"Для взрослых\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":19,\n" +
            "               \"name\":\"Игры\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":20,\n" +
            "               \"name\":\"Автотовары\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":21,\n" +
            "               \"name\":\"Услуги\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":22,\n" +
            "               \"name\":\"Работа и образование\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":23,\n" +
            "               \"name\":\"Инструменты и садовая техника\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":24,\n" +
            "               \"name\":\"Товары для туризма\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":29,\n" +
            "               \"name\":\"Valentine's Days\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":33,\n" +
            "               \"name\":\"Dragon Boat Fest\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":34,\n" +
            "               \"name\":\"Товары из Китая\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":38,\n" +
            "               \"name\":\"China Fest\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":45,\n" +
            "               \"name\":\"Crazy Weekend Fest\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"name\":\"$30 off $300+ Purchase\\r\\n\",\n" +
            "         \"promocode\":\"F54915F6\",\n" +
            "         \"frameset_link\":\"\",\n" +
            "         \"goto_link\":\"https://ad.admitad.com/g/50o26xp0232e4b3978f86a95c12d58/?i=3\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"status\":\"active\",\n" +
            "         \"rating\":\"8.93\",\n" +
            "         \"campaign\":{\n" +
            "            \"id\":14622,\n" +
            "            \"name\":\"DHgate WW\",\n" +
            "            \"site_url\":\"http://dhgate.com/\"\n" +
            "         },\n" +
            "         \"description\":\"On Sale! 50% Off Sports Shoes! Shop now at wholesale price\",\n" +
            "         \"short_name\":\"On Sale! 50% Off Sports Shoes! Shop now at wholesale price\",\n" +
            "         \"exclusive\":false,\n" +
            "         \"date_end\":null,\n" +
            "         \"date_start\":\"2019-05-10T13:50:42\",\n" +
            "         \"id\":245342,\n" +
            "         \"regions\":[\n" +
            "            \"AE\",\n" +
            "            \"AR\",\n" +
            "            \"AU\",\n" +
            "            \"BE\",\n" +
            "            \"BO\",\n" +
            "            \"BR\",\n" +
            "            \"BY\",\n" +
            "            \"CA\",\n" +
            "            \"CH\",\n" +
            "            \"CL\",\n" +
            "            \"CO\",\n" +
            "            \"CW\",\n" +
            "            \"CZ\",\n" +
            "            \"DE\",\n" +
            "            \"DK\",\n" +
            "            \"ES\",\n" +
            "            \"FI\",\n" +
            "            \"FR\",\n" +
            "            \"GB\",\n" +
            "            \"GR\",\n" +
            "            \"HU\",\n" +
            "            \"IE\",\n" +
            "            \"IL\",\n" +
            "            \"IT\",\n" +
            "            \"JP\",\n" +
            "            \"KR\",\n" +
            "            \"KZ\",\n" +
            "            \"LU\",\n" +
            "            \"MT\",\n" +
            "            \"MX\",\n" +
            "            \"NL\",\n" +
            "            \"NO\",\n" +
            "            \"NZ\",\n" +
            "            \"PA\",\n" +
            "            \"PE\",\n" +
            "            \"PF\",\n" +
            "            \"PH\",\n" +
            "            \"PK\",\n" +
            "            \"PL\",\n" +
            "            \"PR\",\n" +
            "            \"PT\",\n" +
            "            \"RO\",\n" +
            "            \"RU\",\n" +
            "            \"SA\",\n" +
            "            \"SE\",\n" +
            "            \"SG\",\n" +
            "            \"SI\",\n" +
            "            \"TR\",\n" +
            "            \"UA\",\n" +
            "            \"US\"\n" +
            "         ],\n" +
            "         \"discount\":\"50%\",\n" +
            "         \"types\":[\n" +
            "            {\n" +
            "               \"id\":2,\n" +
            "               \"name\":\"Скидка на заказ\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"image\":\"http://cdn.admitad.com/campaign/images/2016/01/13/2cf320fa4ad27267779b03a5a85ac024.jpg\",\n" +
            "         \"species\":\"action\",\n" +
            "         \"categories\":[\n" +
            "            {\n" +
            "               \"id\":4,\n" +
            "               \"name\":\"Обувь \"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":6,\n" +
            "               \"name\":\"Спорт и отдых\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":12,\n" +
            "               \"name\":\"Туры и путешествия\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":24,\n" +
            "               \"name\":\"Товары для туризма\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"name\":\"On Sale! 50% Off Sports Shoes! Shop now at wholesale price\",\n" +
            "         \"promocode\":\"NOT REQUIRED\",\n" +
            "         \"frameset_link\":\"\",\n" +
            "         \"goto_link\":\"https://ad.admitad.com/g/ozex303obg2e4b3978f86a95c12d58/?i=3\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"status\":\"active\",\n" +
            "         \"rating\":\"8.86\",\n" +
            "         \"campaign\":{\n" +
            "            \"id\":14622,\n" +
            "            \"name\":\"DHgate WW\",\n" +
            "            \"site_url\":\"http://dhgate.com/\"\n" +
            "         },\n" +
            "         \"description\":\"\",\n" +
            "         \"short_name\":\"$10 off $100+Purchase\\r\\n\",\n" +
            "         \"exclusive\":true,\n" +
            "         \"date_end\":\"2020-12-31T23:59:00\",\n" +
            "         \"date_start\":\"2020-02-21T00:00:00\",\n" +
            "         \"id\":299305,\n" +
            "         \"regions\":[\n" +
            "            \"AE\",\n" +
            "            \"AR\",\n" +
            "            \"AU\",\n" +
            "            \"BE\",\n" +
            "            \"BO\",\n" +
            "            \"BR\",\n" +
            "            \"BY\",\n" +
            "            \"CA\",\n" +
            "            \"CH\",\n" +
            "            \"CL\",\n" +
            "            \"CO\",\n" +
            "            \"CW\",\n" +
            "            \"CZ\",\n" +
            "            \"DE\",\n" +
            "            \"DK\",\n" +
            "            \"ES\",\n" +
            "            \"FI\",\n" +
            "            \"FR\",\n" +
            "            \"GB\",\n" +
            "            \"GR\",\n" +
            "            \"HU\",\n" +
            "            \"IE\",\n" +
            "            \"IL\",\n" +
            "            \"IT\",\n" +
            "            \"JP\",\n" +
            "            \"KR\",\n" +
            "            \"KZ\",\n" +
            "            \"LU\",\n" +
            "            \"MT\",\n" +
            "            \"MX\",\n" +
            "            \"NL\",\n" +
            "            \"NO\",\n" +
            "            \"NZ\",\n" +
            "            \"PA\",\n" +
            "            \"PE\",\n" +
            "            \"PF\",\n" +
            "            \"PH\",\n" +
            "            \"PK\",\n" +
            "            \"PL\",\n" +
            "            \"PR\",\n" +
            "            \"PT\",\n" +
            "            \"RO\",\n" +
            "            \"RU\",\n" +
            "            \"SA\",\n" +
            "            \"SE\",\n" +
            "            \"SG\",\n" +
            "            \"SI\",\n" +
            "            \"TR\",\n" +
            "            \"UA\",\n" +
            "            \"US\"\n" +
            "         ],\n" +
            "         \"discount\":\"10%\",\n" +
            "         \"types\":[\n" +
            "            {\n" +
            "               \"id\":2,\n" +
            "               \"name\":\"Скидка на заказ\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"image\":\"http://cdn.admitad.com/campaign/images/2016/01/13/2cf320fa4ad27267779b03a5a85ac024.jpg\",\n" +
            "         \"species\":\"promocode\",\n" +
            "         \"categories\":[\n" +
            "            {\n" +
            "               \"id\":1,\n" +
            "               \"name\":\"Товары для детей\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":2,\n" +
            "               \"name\":\"Красота и здоровье\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":3,\n" +
            "               \"name\":\"Аксессуары и сумки\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":4,\n" +
            "               \"name\":\"Обувь \"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":5,\n" +
            "               \"name\":\"Одежда\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":6,\n" +
            "               \"name\":\"Спорт и отдых\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":7,\n" +
            "               \"name\":\"Товары для дома\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":8,\n" +
            "               \"name\":\"Компьютеры и электроника\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":9,\n" +
            "               \"name\":\"Цветы и подарки\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":10,\n" +
            "               \"name\":\"Часы и украшения\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":11,\n" +
            "               \"name\":\"Еда\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":12,\n" +
            "               \"name\":\"Туры и путешествия\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":14,\n" +
            "               \"name\":\"Книги\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":15,\n" +
            "               \"name\":\"Финансы и страхование\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":17,\n" +
            "               \"name\":\"Зоотовары\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":18,\n" +
            "               \"name\":\"Для взрослых\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":19,\n" +
            "               \"name\":\"Игры\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":20,\n" +
            "               \"name\":\"Автотовары\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":21,\n" +
            "               \"name\":\"Услуги\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":22,\n" +
            "               \"name\":\"Работа и образование\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":23,\n" +
            "               \"name\":\"Инструменты и садовая техника\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":24,\n" +
            "               \"name\":\"Товары для туризма\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":29,\n" +
            "               \"name\":\"Valentine's Days\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":33,\n" +
            "               \"name\":\"Dragon Boat Fest\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":34,\n" +
            "               \"name\":\"Товары из Китая\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":38,\n" +
            "               \"name\":\"China Fest\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"id\":45,\n" +
            "               \"name\":\"Crazy Weekend Fest\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"name\":\"$10 off $100+Purchase\\r\\n\",\n" +
            "         \"promocode\":\"35C4ED15\",\n" +
            "         \"frameset_link\":\"\",\n" +
            "         \"goto_link\":\"https://ad.admitad.com/g/a82pudggro2e4b3978f86a95c12d58/?i=3\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"status\":\"active\",\n" +
            "         \"rating\":\"8.85\",\n" +
            "         \"campaign\":{\n" +
            "            \"id\":14622,\n" +
            "            \"name\":\"DHgate WW\",\n" +
            "            \"site_url\":\"http://dhgate.com/\"\n" +
            "         },\n" +
            "         \"description\":\"On Sale! 50% Off Women's Shoes! Shop now at wholesale price\",\n" +
            "         \"short_name\":\"On Sale! 50% Off Women's Shoes! Shop now at wholesale price\",\n" +
            "         \"exclusive\":false,\n" +
            "         \"date_end\":null,\n" +
            "         \"date_start\":\"2019-05-10T13:49:50\",\n" +
            "         \"id\":245341,\n" +
            "         \"regions\":[\n" +
            "            \"AE\",\n" +
            "            \"AR\",\n" +
            "            \"AU\",\n" +
            "            \"BE\",\n" +
            "            \"BO\",\n" +
            "            \"BR\",\n" +
            "            \"BY\",\n" +
            "            \"CA\",\n" +
            "            \"CH\",\n" +
            "            \"CL\",\n" +
            "            \"CO\",\n" +
            "            \"CW\",\n" +
            "            \"CZ\",\n" +
            "            \"DE\",\n" +
            "            \"DK\",\n" +
            "            \"ES\",\n" +
            "            \"FI\",\n" +
            "            \"FR\",\n" +
            "            \"GB\",\n" +
            "            \"GR\",\n" +
            "            \"HU\",\n" +
            "            \"IE\",\n" +
            "            \"IL\",\n" +
            "            \"IT\",\n" +
            "            \"JP\",\n" +
            "            \"KR\",\n" +
            "            \"KZ\",\n" +
            "            \"LU\",\n" +
            "            \"MT\",\n" +
            "            \"MX\",\n" +
            "            \"NL\",\n" +
            "            \"NO\",\n" +
            "            \"NZ\",\n" +
            "            \"PA\",\n" +
            "            \"PE\",\n" +
            "            \"PF\",\n" +
            "            \"PH\",\n" +
            "            \"PK\",\n" +
            "            \"PL\",\n" +
            "            \"PR\",\n" +
            "            \"PT\",\n" +
            "            \"RO\",\n" +
            "            \"RU\",\n" +
            "            \"SA\",\n" +
            "            \"SE\",\n" +
            "            \"SG\",\n" +
            "            \"SI\",\n" +
            "            \"TR\",\n" +
            "            \"UA\",\n" +
            "            \"US\"\n" +
            "         ],\n" +
            "         \"discount\":\"50%\",\n" +
            "         \"types\":[\n" +
            "            {\n" +
            "               \"id\":2,\n" +
            "               \"name\":\"Скидка на заказ\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"image\":\"http://cdn.admitad.com/campaign/images/2016/01/13/2cf320fa4ad27267779b03a5a85ac024.jpg\",\n" +
            "         \"species\":\"action\",\n" +
            "         \"categories\":[\n" +
            "            {\n" +
            "               \"id\":4,\n" +
            "               \"name\":\"Обувь \"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"name\":\"On Sale! 50% Off Women's Shoes! Shop now at wholesale price\",\n" +
            "         \"promocode\":\"NOT REQUIRED\",\n" +
            "         \"frameset_link\":\"\",\n" +
            "         \"goto_link\":\"https://ad.admitad.com/g/yu98rbsv7n2e4b3978f86a95c12d58/?i=3\"\n" +
            "      }\n" +
            "   ]\n" +
            "}";

    /**
     * Create a private constructor because no one should ever create a {@link CouponUtils} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name QueryUtils (and an object instance of QueryUtils is not needed).
     */
    private CouponUtils() {
    }

    /**
     * Return a list of {@link CouponCategory} objects that has been built up from
     * parsing a JSON response.
     */
    public static ArrayList<CouponCategory> extractCouponcategory() {

        // Create an empty ArrayList that we can start adding coupon to
        ArrayList<CouponCategory> couponcategory = new ArrayList<>();

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            // TODO: Parse the response given by the SAMPLE_JSON_RESPONSE string and
            // build up a list of coupon code objects with the corresponding data.

            JSONObject baseJsonResponse = new JSONObject(SAMPLE_JSON_RESPONSE);
            JSONArray couponCategoryArray = baseJsonResponse.getJSONArray("results");

            for (int i = 0; i < couponCategoryArray.length(); i++) {

                JSONObject currentEarthquake = couponCategoryArray.getJSONObject(i);
                JSONObject properties = currentEarthquake.getJSONObject("campaign");
                String name = properties.getString("name");

                String coupon_short_description = currentEarthquake.getString("name");

                String promo_code = currentEarthquake.getString("promocode");

                String rating = currentEarthquake.getString("rating");

                String goto_store = currentEarthquake.getString("goto_link");

                CouponCategory couponCategory = new CouponCategory(name, coupon_short_description, promo_code, rating, goto_store);
                couponcategory.add(couponCategory);

            }

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
        }


        // Return the list of coupon
        return couponcategory;
    }

}
