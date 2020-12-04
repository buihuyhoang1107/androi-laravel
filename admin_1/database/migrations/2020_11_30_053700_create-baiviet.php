<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateBaiviet extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('baiviets', function (Blueprint $table) {
            $table->id();   
            $table->string('ten');
            $table->Integer('chude_id');
            $table->Integer('vungmien_id');
            $table->string('nguyenlieu');
            $table->string('soche');
            $table->string('thuchien');
            $table->string('cachdung');
            $table->Integer('action')->default(1);
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
        Schema::dropIfExists('baiviets');
    }
}
