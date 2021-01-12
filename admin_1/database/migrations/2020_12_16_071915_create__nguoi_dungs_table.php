<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateNguoiDungsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('nguoidungs', function (Blueprint $table) {
            $table->id();
            $table->string('ten');
            $table->string('gmail');
            $table->string('matkhau');
            $table->Integer('phanquyen')->default(0);
            $table->Integer('action')->default(0);  
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('nguoidungs');
    }
}
