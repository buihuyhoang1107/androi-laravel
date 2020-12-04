<?php

use Illuminate\Database\Seeder;

class CategorySeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('categories')->insert([
            ['title' => 'Ẩm thực đường phố‎'],
            ['title' => 'Ẩm thực theo lục địa‎'],
            ['title' => 'Ẩm thực chay‎'],
            ['title' => 'Các món ăn từ cá'],
            ['title' => 'Các món ăn từ thịt‎'],
            ['title' => 'Món cuốn'],
        ]);
    }
}
