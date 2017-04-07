FactoryGirl.define do
  factory :user do
    name { Faker::Lorem.word }
    sex { Faker::Lorem.word }
    city { Faker::Lorem.word }
    address { Faker::Lorem.word }
    email { Faker::Internet.email}
    password { Faker::PhoneNumber.phone_number}
    age { Faker::Number.number(3) }

  end
end