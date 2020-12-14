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
            ['ten_vungmien' => 'Miền Bắc‎'],
            ['ten_vungmien' => 'Miền Nam‎'],
            ['ten_vungmien' => 'Miền Trung‎'],
        ]);
    }
}
