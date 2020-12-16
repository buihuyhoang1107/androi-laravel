<?php

use Illuminate\Database\Seeder;

class BaivietSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('baiviets')->insert([
             ['ten' => 'Trà sữa hoa đậu biếc',
             'category_id'=>'1',
             'vungmien_id'=>'2',
             'hinhanh'=>'202012160322044743.jfif',
             'nguyenlieu'=>'M: muỗng canh - m: muỗng cafe
                            Hoa đậu biếc khô	10 hoa
                            Trà Sữa Royal "Blendy"	2 gói
                            Soda	1 lon
                            Đá bi
                            Gia vị: đường',
             'soche'=>'– Hoa đậu biếc ngâm với 50ml nước nóng, lọc lấy nước cốt
             – Pha 2 gói trà sữa Royal “Blendy” với 60ml nước sôi, khuấy tan, để nguội.',
             'thuchien'=>'– Cho đá vào ly, rót trà sữa vào, rót soda lên trên, cuối cùng cho cốt hoa đậu biếc lên trên cùng. Trang trí hoa đậu biếc',
             'cachdung'=>'– Khuấy đều và thưởng thức'],


             ['ten' => 'Thăn heo chiên giòn rau quế',
             'category_id'=>'2',
             'vungmien_id'=>'1',
             'hinhanh'=>'202012160323491947.jfif',
            'nguyenlieu'=>'M: muỗng canh - m: muỗng cafe

             Thịt thăn ngoại	300g
             Rau quế	20 lá
             Ăn kèm : xà lách, cà chua bi
             Gia vị : Dầu ăn, tỏi băm
             Xốt Mayonnaise Xốt Mayonnaise Aji-mayo®
             Gia vị nêm sẵn Gia vị nêm sẵn Aji-Quick® Bột tẩm khô chiên giòn Bột tẩm khô chiên giòn',
             'soche'=>'– Thăn heo cắt lát mỏng 5mm vừa ăn, đập dập, khứa vảy rồng 2 mặt.

             – Rau quế lấy 10 lá cắt sợi nhuyễn, phần còn lại để riêng.',
             'thuchien'=>'– Đun nóng dầu ăn, chiên giòn lá quế, vớt ra để ráo. Tẩm thịt heo với 1 gói Gia vị nêm sẵn Aji-Quick® Bột Tẩm Khô Chiên Giòn, đem chiên chín vàng, vớt thịt ra để nghỉ ít phút rồi cho thịt vào chiên lần 2, đến khi thịt chín vàng, vớt ra để ráo dầu.

             – Pha xốt: Trộn đều 2M Xốt Mayonnaise Aji-mayo®, 1M rau quế và 1m tỏi băm.',
             'cachdung'=>'– Xếp thịt ra dĩa, khi ăn chấm kèm xốt pha.'],

             ['ten' => 'Chả đùm dê',
             'category_id'=>'3',
             'vungmien_id'=>'2',
             'hinhanh'=>'202012160325474790.jfif',
             'nguyenlieu'=>'M: muỗng canh - m: muỗng cafe

             Thịt dê	300g
             Giò sống	50g
             Gan gà hoặc vịt	2 bộ
             Mỡ chài	2 miếng 20cm
             Đậu petit pois	50g
             Hành tím băm	2M
             Tỏi băm	1M
             Bún tàu	1 lọn nhỏ
             Lòng đỏ trứng muối	2 cái
             Sữa tươi không đường	50ml
             Hành lá	2 nhánh
             Đậu phộng rang	2M
             Bột năng	1m
             Tiêu xanh	1M
             Nấm mèo	2M
             RAU NÊM: Rau om, ngò gai, ớt lát
             ĂN KÈM: Bánh tráng nướng, nước tương, ớt sa tế
             Gia vị: dầu ăn, muối, tiêu, đường, rượu Mai Quế Lộ
             Bột ngọt Bột ngọt AJI-NO-MOTO®
             Hạt nêm Hạt nêm Aji-ngon® Heo Heo',
             'soche'=>'– Thịt dê xay nhỏ. Mỡ chài xát muối và rượu, rửa sạch.

             – Gan gà làm sạch, ngâm sữa 30′ vớt để ráo. Hòa bột năng với sữa.
             
             – Bún tàu ngâm mềm, cắt khúc. Hành lá cắt nhỏ.
             
             – Đun nóng dầu làm mỡ hành. Hòa 1m đường với nước',
             'thuchien'=>'– Phi thơm hành tỏi, cho gan gà vào xào săn, khử 1m rượu Mai Quế Lộ, để nguội. Xay nhuyễn cùng với sữa pha bột năng.

             – Trộn thịt dê, gan, giò sống vào máy quết dẻo. Thêm bún tàu, đậu petit pois, nấm mèo, tiêu xanh, nêm 1/3m muối, 1m tiêu, 2m đường, 1m Bột ngọt AJI-NO-MOTO®, 2m Hạt nêm Aji-ngon® Heo vào quết đều.
             
             – Trải mỡ chài vào chén, cho lòng đỏ trứng muối và cho nhân vào, bọc kín viên nhân. Hấp chả chín. Sau đó úp ngược chả ra khay nướng.
             
             – Mở lò nướng nóng 250°C. Phết nước đường lên mặt chả, nướng vàng nâu.',
             'cachdung'=>'– Cắt chả ra miếng vừa ăn. Phết mỡ hành và rải đậu phộng lên trên. Dùng chung với bánh tráng. Nước tương tương ớt hay ớt sa tế.'],

             ['ten' => 'Bún gạo xào mayo',
             'category_id'=>'1',
             'vungmien_id'=>'3',
             'hinhanh'=>'20201216032638590.jfif',
             'nguyenlieu'=>'M: muỗng canh - m: muỗng cafe

             Bún gạo khô:	150g
             Thịt bò phi lê:	100g
             Cà rốt cắt sợi:	50g
             Bông hẹ:	50g
             Nấm đông cô cắt sợi:	50g
             Ớt sừng:	1 trái
             RAU NÊM: Ngò rí
             GIA VỊ: Hành tỏi băm, muối, đường, tiêu, bột năng, dầu ăn, tương ớt
             Bột ngọt Bột ngọt AJI-NO-MOTO®
             Xốt Mayonnaise Xốt Mayonnaise Aji-mayo®
             Nước tương Nước tương ',
             'soche'=>'– Thịt bò cắt mỏng, ướp 1/2m đường, 1/2m bột ngọt AJI-NO-MOTO®, 1M nước tương “Phú Sĩ” và 2m tỏi băm, để thấm.

             – Bún gạo ngâm nước ấm 5 phút, vớt ra để ráo.
             
             – Bông hẹ cắt khúc. Ớt sừng bỏ hạt, cắt sợi.
             
             – Khuấy tan xốt xào: 1m đường, 1m bột ngọt AJI-NO-MOTO®, 2M nước tương “Phú Sĩ”.',
             'thuchien'=>'– Phi thơm tỏi, xào thịt bò, trút ra để riêng. Cho cà rốt, nấm vào xào nhanh, cho tiếp bông hẹ, ớt sừng vào, và cho bún gạo vào, nêm xốt xào, trộn nhanh tay cho các nguyên liệu đều nhau, tắt lửa.',
             'cachdung'=>'– Cho bún xào ra dĩa, xếp thịt bò lên trên, tạo hình zic zac với Xốt Mayonnaise Aji-mayo® và tương ớt. Khi ăn trộn đều.'],

             ['ten' => 'Lẩu gà cơm mẻ',
             'category_id'=>'5',
             'vungmien_id'=>'2',
             'hinhanh'=>'202012160328009504.jfif',
             'nguyenlieu'=>'M: muỗng canh - m: muỗng cafe Gà tre 1 con (1,2kg) Mẻ 5M Hành tím bào, 50g Ớt đỏ sừng	5 trái Cà chua 1 trái Riềng 1M Sả, 4 cây Rau nêm : Lá quế, ngò rí, hành lá',
             'soche'=>'– Gà rửa sạch, chặt miếng vừa ăn. Khuấy đều 2M mẻ và 1/2M Hạt nêm Aji-ngon® Gà, ướp gà, để thấm 15 phút. – Mẻ tán nhuyễn. Cà chua cắt múi cau. Riềng cắt sợi.',
             'thuchien'=>'Phi thơm hành tím, ớt sừng, riềng, sả với dầu ăn, xào gà săn, nêm 1M đường, 2M nước mắm, 1m Bột ngọt AJI-NO-MOTO®, 1/2M Hạt nêm Aji-ngon® Gà.',
             'cachdung'=>'Dùng nóng kèm các loại rau, bún và nước mắm ớt.'],  

             ['ten' => 'Tôm rim thịt thơm',
             'category_id'=>'6',
             'vungmien_id'=>'2',
             'hinhanh'=>'202012160329093458.jfif',
             'nguyenlieu'=>'M: muỗng canh - m: muỗng cafe

             Tôm bạc thẻ tươi:	300g
             Thịt ba chỉ :	200g
             Thơm:	1/2 trái
             Hành tây:	1/2 củ
             Hành lá
             Ớt sừng:	1 ít
             Gia vị: Tiêu, đường, nước mắm, dầu điều, dầu ăn, ớt bột, hành tỏi băm, hành lá',
             'soche'=>'– Tôm làm sạch, cắt đầu và đuôi, xẻ dọc sống lưng. Thịt ba chỉ cắt lát dày 2mm bản to.

             – Thơm xẻ dọc, cắt lát dày 4mm. Hành lá cắt khúc 3cm. Ớt sừng bỏ hạt, cắt xéo.',
             'thuchien'=>'– Phi thơm hành tỏi với 2M dầu ăn, 1M dầu điều, cho thịt vào đảo cho thịt săn và thơm, tiết ra ít mỡ. Cho tôm vào đảo đều cho tôm săn lại, nêm 2m đường, 1m Bột ngọt AJI-NO-MOTO®, 2M nước mắm, 1/2m ớt bột, rim 2 – 3 phút rồi cho thơm vào, cho thêm hành tây và hành lá, nếu thấy ít nước, không đủ thời gian cho thấm vị thì thêm 2M nước, rim nhỏ lửa cho đến khi nước thịt và tôm rim sánh lại, tôm bóng giòn. Tắt lửa, rắc tiêu và hành lá.',
             'cachdung'=>'– Dùng kèm cơm trắng.'],

             ['ten' => 'Cơm chanh ấn độ',   
             'category_id'=>'4',
             'vungmien_id'=>'1',
             'hinhanh'=>'202012160330075535.jfif',
             'nguyenlieu'=>'M: muỗng canh - m: muỗng cafe

             Thịt gà:	150g
             Cơm nguội:	2 chén
             Đậu phộng khô:	50g
             Hạt mù tạt:	1m
             Chanh vàng:	1 quả
             Hành tây tím:	1/2 củ
             RAU NÊM: Lá chanh tươi, lá cà ri tươi, ớt sừng xanh đỏ, ngò rí
             Gia vị: Bột nghệ, muối, dầu ăn
             Hạt nêm Hạt nêm Aji-ngon® Gà Gà',
             'soche'=>'– Thịt gà cắt hạt lựu. Ướp thịt gà với 1m bột nghệ, 1m Hạt nêm Aji-ngon® Gà.

             – Lá chanh băm nhỏ. Lá cà ri xé nhỏ (để nguyên vài lá chiên trang trí). Ớt xanh đỏ cắt hình thoi. Chanh vàng mài vỏ, sau đó vắt lấy nước cốt.',
             'thuchien'=>'– Đun nóng 1/2 chén dầu, chiên lá cà ri, vớt ra và bớt dầu chừa lại 2M. Tiếp tục cho đậu phộng vào xào với lửa nhỏ đến khi đậu phộng chín, thêm 1m hạt mù tạt, hành tím, 1M lá cà ri, cho thịt gà vào xào thơm. Khi tất cả nguyên liệu vừa chín thì tắt lửa, thêm 2M nước cốt chanh và 1M vỏ chanh vào. Múc nhân ra dĩa.

             – Phi thơm hành tím với 1M dầu ăn, cho cơm vào đảo đều, nêm 2/3m Hạt nêm Aji-ngon® Gà, cho nhân vào trộn đều, xào với lửa nhẹ. Tắt lửa cho lá chanh băm nhỏ vào.',
             'cachdung'=>'– Múc cơm ra dĩa, trang trí ngò rí, ớt và lá cà ri chiên lên mặt, dùng nóng.  '], 

             ['ten' => 'Cá kèo nướng muối ớt',   
             'category_id'=>'3',
             'vungmien_id'=>'2',
             'hinhanh'=>'202012160331042575.jfif',
             'nguyenlieu'=>'M: muỗng canh - m: muỗng cafe

             Cá kèo:	300g
             Muối ớt tôm khô Tây Ninh:	2M
             Rau nêm: Rau răm
             Ăn kèm: Muối ớt, dưa leo muối xổi, chanh
             Gia vị: Ớt bột, tỏi, cốt chanh, dầu hào, dầu ăn, dầu điều, tương ớt, đậu phộng rang, ớt sừng xanh
             Bột ngọt Bột ngọt AJI-NO-MOTO®
             Hạt nêm Hạt nêm Aji-ngon® Heo Heo',
             'soche'=>'– Cá kèo làm sạch, xiên que. Trộn đều 1m Hạt nêm Aji-ngon® Heo, 2M muối ớt tôm khô, 1M tương ớt, 1/2m dầu hào, 2m nước mắm, 1/2m dầu điều và 2m dầu ăn. Ướp cá thấm gia vị.

             – Đậu phộng rang giã nhuyễn.',
             'thuchien'=>'– Áp chảo cá trên chảo đến khi chín vàng.

             – Pha muối ớt chấm: Giã nhuyễn 2M muối hột, 1m Bột ngọt AJI-NO-MOTO®, 1/2m ớt bột, 2 trái ớt sừng xanh.',
             'cachdung'=>'– Xếp cá ra dĩa rắc thêm 2M đậu phộng rang giã nhuyễn, dùng kèm rau răm, chấm muối ớt vắt thêm chanh.'],

             ['ten' => 'Súp măng vịt chua cay',   
             'category_id'=>'2',
             'vungmien_id'=>'1',
             'hinhanh'=>'202012160332026535.jfif',
             'nguyenlieu'=>'M: muỗng canh - m: muỗng cafe

             Vịt quay:	1/4 con
             Măng vàng luộc:	80g
             Giá:	40g
             Nấm đùi gà:	80g
             Đậu hũ non:	80g
             Bột năng:	2M
             Dầu mè:	1m
             Trứng gà:	1 quả
             RAU NÊM: Ngò rí
             Gia vị: dầu ăn, đường
             Gia vị nêm sẵn Gia vị nêm sẵn Aji-Quick® Lẩu Kim chi Lẩu Kim chi',
             'soche'=>'– Thịt vịt cắt sợi. Xương vịt quay nấu lấy 1,5 lít nước dùng.

             – Trứng gà đánh tan. Măng vàng cắt sợi, chần qua nước sôi. Nấm đùi gà cắt sợi.
             
             – Bột năng hòa tan với nước. Đậu hũ non cắt hạt lựu.',
             'thuchien'=>'– Xào nhanh măng và nấm với ít dầu ăn, cho 1.5 lít nước dùng vào đun sôi, nêm 1 gói Gia vị nêm sẵn Aji-Quick® Lẩu Kim Chi, nếm vị chua cay vừa ăn. Hòa nước bột năng tạo độ sánh cho súp, sau đó cho trứng vào tạo vân mây. Tắt lửa.',
             'cachdung'=>'– Cho giá, đậu hủ non vào tô, múc súp vào và thêm thịt vịt lên trên, thêm dầu mè. Trang trí với ngò rí, dùng nóng.'],

             ['ten' => 'Cá hồi sake chiên giòn',   
             'category_id'=>'2',
             'vungmien_id'=>'1',
             'hinhanh'=>'202012160332531249.jfif',
             'nguyenlieu'=>'M: muỗng canh - m: muỗng cafe

             Fillet cá hồi:	200g
             Sake:	1/6 trái
             Chanh vàng:	1 trái
             Thì là băm:	1m
             Gia vị: Tương ớt, tiêu, dầu ăn
             Hạt nêm Hạt nêm Aji-ngon® Gà Gà
             Gia vị nêm sẵn Gia vị nêm sẵn Aji-Quick® Bột chiên giòn Bột chiên giòn (Tên cũ: Bột Chiên Giòn Hải Sản)',
             'soche'=>'– Cá hồi cắt que dày 7mm. Ướp cá với 1/2M vỏ chanh mài, 1/2m tiêu, 1/2m Hạt nêm Aji-ngon® Gà, 1/2m thì là băm.

             – Sake cắt miếng hình tam giác, dày 5mm, sau đó cắt đôi hình chiếc kẹp.
             
             – Chanh vàng mài vỏ, sau đó vắt nước để riêng.
             
             – Pha 1 gói Gia vị nêm sẵn Aji-Quick® Bột chiên giòn theo hướng dẫn trên bao bì. Để lại 1M bột khô.',
             'thuchien'=>'– Đun nóng dầu ăn, lăn cá qua bột khô, dùng miếng sake kẹp cá vào giữa tẩm qua bột đã pha và chiên giòn chín tới. Vớt ra để ráo dầu.

             – Pha xốt: trộn đều 2M Xốt Mayonnaise Aji-mayo®, 1M tương ớt và 1/2m thì là băm',
             'cachdung'=>'– Xếp cá ra dĩa, dùng nóng chấm kèm xốt đã pha.'],
        ]);
    }
}
