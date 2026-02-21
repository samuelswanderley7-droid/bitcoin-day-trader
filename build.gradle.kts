plugins { 
    id("com.android.application") 
    id("kotlin-android") 
}

android { 
    compileSdk = 33

    defaultConfig { 
        applicationId = "com.example.bitcoindaytrader" 
        minSdk = 21 
        targetSdk = 33 
        versionCode = 1 
        versionName = "1.0"
    }

    buildTypes { 
        release { 
            isMinifyEnabled = false 
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro") 
        }
    }
}

dependencies { 
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.31") 
    implementation("com.android.support:appcompat-v7:29.0.0") 
    implementation("com.squareup.retrofit2:retrofit:2.9.0") 
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") 
    // Add other dependencies as needed
}