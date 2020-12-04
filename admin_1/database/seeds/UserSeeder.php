<?php

use Illuminate\Database\Seeder;

class UserSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        for($i=0;$i<10;$i++){
            DB::table('users')->insert([
                'name' => 'user'.$i,
                'email' => 'user'.$i.'@gmail.com',
                'password' => Hash::make('123456'),
            ]);
        }
       
    }
}
