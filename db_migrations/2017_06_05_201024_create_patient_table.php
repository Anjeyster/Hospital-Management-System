<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreatePatientTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('patient', function (Blueprint $table) {
            $table->increments('id');
             $table->string('name');
            $table->string('address')->nullable();
            $table->string('phone')->nullable();
            $table->string('nic')->nullable();
            $table->string('email')->nullable();
            $table->boolean('isAdmitted')->default(0);
            $table->string('emergency_contact');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('patient');
    }
}
