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
            ['title' => 'Miền Bắc‎'],
            ['title' => 'Miền Nam‎'],
            ['title' => 'Miền Trung‎'],
        ]);
    }
}
