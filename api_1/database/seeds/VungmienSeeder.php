<?php

use Illuminate\Database\Seeder;

class VungmienSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('vungmiens')->insert([
            ['ten_vungmien' => 'Miền Bắc‎','noidung'=>'Miền Bắc không chỉ được biết đến qua những danh lam thắng cảnh những ngôi chùa lọt Top thế giới tiêu biểu như Vịnh Hạ Long Sa Pa hay chùa Yên Tử, chùa Tam Chúc, chùa Hương, Bái Đính... mà còn được biết qua câu tục ngữ “Ăn Bắc Mặc Nam” .Vì chia ra thành nhiều tiểu vùng như Đồng bằng sông Hồng, Tây Bắc, Đông Bắc.. và khí hậu lại có bốn mùa xuân hạ thu đông nên ẩm thực miền Bắc rất đa dạng và đặc trưng.'],
            ['ten_vungmien' => 'Miền Nam‎','noidung'=>'Với những món đặc sản miền Trung vô cùng phong phú và đa dạng, mỗi địa phương có cho mình những sản vật món ăn thơm ngon, hấp dẫn, góp phần tô điểm thêm nét đậm đà mang bản sắc riêng, hương vị riêng cho mảnh đất cằn cỗi, đầy nắng và gió này.'],
            ['ten_vungmien' => 'Miền Trung‎','noidung'=>'Nếu như ẩm thực miền Bắc chú trọng sự tinh tế và cầu kỳ, miền Trung đậm đà hương vị thì văn hóa ẩm thực miền Nam mang nét chân chất, giản đơn rất riêng. Hãy cùng Đào Tạo Bếp Trưởng Á Âu khám phá những nét đặc trưng văn hóa ẩm thực miền Nam nhé.
            Khi nhắc đến miền Nam thì người ta thường nghĩ đến câu “dưới sông có cá, trên bờ có rau”. Đây là một vùng đất phì nhiêu, màu mỡ được bồi đắp bởi hệ thống các sông, kênh, rạch chằng chịt. Miền Nam luôn được thiên nhiên ưu đãi rất nhiều sản vật đa dạng, phong phú. Ẩm thực Nam Bộ mang nét phóng khoáng và hoang dã bởi chính thiên nhiên trù phú và hào phóng của miền sông nước phương Nam.'],
        ]);
    }
}
