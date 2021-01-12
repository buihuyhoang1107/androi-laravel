<?php

use Illuminate\Database\Seeder;

class NguoiDungSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('nguoidungs')->insert([
            'ten' => 'dothanhon',
            'gmail' => 'admin@gmail.com',
            'matkhau' =>Hash::make('123456'),
            'phanquyen'=>1,
        ]);
        for($i=0;$i<10;$i++){
            DB::table('nguoidungs')->insert([
                'ten' => 'user'.$i,
                'gmail' => 'user'.$i.'@gmail.com',
                'matkhau' => Hash::make('123456'),
                'phanquyen'=>0,
            ]);
        }
    }
}
