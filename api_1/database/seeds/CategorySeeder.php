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
            ['title' => 'Đường phố‎','hinhanh'=>'202012170135438619.jpg'],
            ['title' => 'Lục địa','hinhanh'=>'202012170137464554.jpg'],
            ['title' => 'Món Chay‎','hinhanh'=>'202012170138539155.jpg'],
            ['title' => 'Món Cá','hinhanh'=>'202012170140154768.jpg'],
            ['title' => 'Món Thịt‎','hinhanh'=>'2020121701411561.jpg'],
            ['title' => 'Món cuốn','hinhanh'=>'202012170142039386.jpg'],
        ]);
    }
}
