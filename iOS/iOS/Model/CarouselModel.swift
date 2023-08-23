//
//  CarouselModel.swift
//  iOS
//
//  Created by Financial CB on 2023/08/23.
//

import Foundation

struct CarouselModel: Hashable, Codable, Identifiable {
    let id: Int
    let image: String
    let title: String
    let text: String
}
